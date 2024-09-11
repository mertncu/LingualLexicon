package com.eosdev.linguallexicon.ui.learned

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.eosdev.linguallexicon.data.model.Word
import com.eosdev.linguallexicon.databinding.FragmentLearnedWordsBinding
import com.eosdev.linguallexicon.ui.words.adapter.WordsAdapter
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException


class LearnedWordsFragment : Fragment() {

    private lateinit var binding: FragmentLearnedWordsBinding
    private lateinit var adapter: WordsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLearnedWordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadLearnedWords()
    }

    private fun loadLearnedWords() {
        val learnedWords = getLearnedWordsFromPreferences()
        adapter = WordsAdapter(learnedWords) { wordModel ->
            val action =
                com.eosdev.linguallexicon.ui.learned.LearnedWordsFragmentDirections.actionLearnedWordsToDetail(
                    wordModel
                )
            findNavController().navigate(action)
        }
        binding.rvLearnedWordList.adapter = adapter
        updateUI(learnedWords.isEmpty())
    }

    private fun getLearnedWordsFromPreferences(): List<Word> {
        val sharedPreferences = requireActivity().getSharedPreferences("learned_words", Context.MODE_PRIVATE)
        val learnedWordsJson = sharedPreferences.getString("learned_words_list", null) ?: return emptyList()

        return try {
            Gson().fromJson(learnedWordsJson, Array<Word>::class.java).toList()
        } catch (e: JsonSyntaxException) {
            Log.e("LearnedWordsFragment", "Error parsing learned words JSON", e)
            emptyList()
        }
    }

    private fun setupRecyclerView() {
        binding.rvLearnedWordList.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun updateUI(isEmpty: Boolean) {
        binding.tvEmpty.visibility = if (isEmpty) View.VISIBLE else View.GONE
        binding.lottieAnimationView.visibility = if (isEmpty) View.VISIBLE else View.GONE
    }
}




