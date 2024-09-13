package com.eosdev.linguallexicon.ui.random


import android.content.Context

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.eosdev.linguallexicon.data.model.Word
import com.eosdev.linguallexicon.databinding.FragmentRandomWordsDetailBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import java.util.Locale


class RandomWordsDetailFragment : Fragment(), TextToSpeech.OnInitListener {

    private lateinit var binding: FragmentRandomWordsDetailBinding
    private lateinit var textToSpeech: TextToSpeech
    private val bundle: com.eosdev.linguallexicon.ui.random.RandomWordsDetailFragmentArgs by navArgs()
    private var isEnglish: Boolean = true
    private lateinit var word: Word

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRandomWordsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeTextToSpeech()
        setupUI()
        setupListeners()
    }

    private fun initializeTextToSpeech() {
        textToSpeech = TextToSpeech(requireContext(), this)
    }

    private fun setupUI() {
        word = bundle.wordModel
        with(binding) {
            tvEnglishName.text = word.englishName
            tvTurkishName.text = word.turkishName
            tvEnglishSentence.text = word.englishSentence
            tvTurkishSentence.text = word.turkishSentence
            ivWord.setImageResource(word.image)
        }
    }

    private fun setupListeners() {
        binding.apply {
            btnBack.setOnClickListener { findNavController().navigateUp() }

            listenEnglish.setOnClickListener {
                isEnglish = true
                speakOut(word.englishSentence)
            }

            listenTurkish.setOnClickListener {
                isEnglish = false
                speakOut(word.turkishSentence)
            }

            btnLearned.setOnClickListener {
                markWordAsLearned()
                Toast.makeText(it.context, "Congrats!, Word '' ${word.englishName} '' Learned!", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }
        }
    }

    private fun markWordAsLearned() {
        val sharedPreferences = requireActivity().getSharedPreferences("learned_words", Context.MODE_PRIVATE)
        val gson = Gson()
        val learnedWordsJson = sharedPreferences.getString("learned_words_list", null)
        val learnedWords = learnedWordsJson?.let {
            gson.fromJson(it, Array<Word>::class.java).toMutableList()
        } ?: mutableListOf()

        if (!learnedWords.contains(word)) {
            learnedWords.add(word)
            sharedPreferences.edit()
                .putString("learned_words_list", gson.toJson(learnedWords))
                .apply()
        }
    }

    private fun speakOut(text: String) {
        textToSpeech.language = if (isEnglish) Locale.US else Locale("tr", "TR")
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language not supported or missing data")
            }
        } else {
            Log.e("TTS", "Initialization failed")
        }
    }

    override fun onDestroy() {
        if (::textToSpeech.isInitialized) {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
        super.onDestroy()
    }
}