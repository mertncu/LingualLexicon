package com.eosdev.linguallexicon.ui.learned

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.eosdev.linguallexicon.data.model.Word
import com.eosdev.linguallexicon.databinding.FragmentLearnedWordsDetailBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import java.util.Locale


class LearnedWordsDetailFragment : Fragment(), TextToSpeech.OnInitListener {


    private lateinit var binding: FragmentLearnedWordsDetailBinding
    private lateinit var textToSpeech: TextToSpeech
    private var isEnglish: Boolean = true
    private val sharedPreferences: SharedPreferences by lazy {
        requireActivity().getSharedPreferences("learned_words", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLearnedWordsDetailBinding.inflate(inflater, container, false)
        textToSpeech = TextToSpeech(requireContext(), this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val wordModel = getWordModelFromArgs()

        setupWordDetails(wordModel)
        setupClickListeners(wordModel)
    }

    private fun getWordModelFromArgs(): Word {
        val bundle: com.eosdev.linguallexicon.ui.learned.LearnedWordsDetailFragmentArgs by navArgs()
        return bundle.wordModel
    }

    private fun setupWordDetails(word: Word) {
        with(binding) {
            tvEnglishNameLearned.text = word.englishName
            tvTurkishNameLearned.text = word.turkishName
            tvEnglishSentenceLearned.text = word.englishSentence
            tvTurkishSentenceLearned.text = word.turkishSentence
            ivWordLearned.setImageResource(word.image)
        }
    }

    private fun setupClickListeners(word: Word) {
        binding.listenEnglishLearned.setOnClickListener {
            isEnglish = true
            speakOut(word.englishSentence)
        }

        binding.listenTurkishLearned.setOnClickListener {
            isEnglish = false
            speakOut(word.turkishSentence)
        }

        binding.btnUnlearned.setOnClickListener {
            unlearnWord(word)
        }

        binding.btnBackLearned.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun unlearnWord(word: Word) {
        val learnedWords = getLearnedWords().toMutableList()


        if (learnedWords.contains(word)) {
            learnedWords.remove(word)
        }


        saveLearnedWords(learnedWords)

        Snackbar.make(binding.root, "${word.englishName} Unlearned!", Snackbar.LENGTH_SHORT)
            .show()
        findNavController().navigateUp()
    }

    private fun getLearnedWords(): List<Word> {
        val learnedWordsJson = sharedPreferences.getString("learned_words_list", null)
        return if (!learnedWordsJson.isNullOrEmpty()) {
            try {
                Gson().fromJson(learnedWordsJson, Array<Word>::class.java).toList()
            } catch (e: Exception) {
                Log.e("LearnedWordsDetail", "Error parsing learned words", e)
                emptyList()
            }
        } else {
            emptyList()
        }
    }

    private fun saveLearnedWords(learnedWords: List<Word>) {
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val updatedLearnedWordsJson = gson.toJson(learnedWords)
        editor.putString("learned_words_list", updatedLearnedWordsJson)
        editor.apply()
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "English language is not supported")
            }
        } else {
            Log.e("TTS", "Initialization failed")
        }
    }

    private fun speakOut(text: String) {
        textToSpeech.language =
            if (isEnglish) Locale.US else Locale("tr", "TR") // Türkçe için dil ayarı
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onDestroy() {
        if (::textToSpeech.isInitialized) {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
        super.onDestroy()
    }

}