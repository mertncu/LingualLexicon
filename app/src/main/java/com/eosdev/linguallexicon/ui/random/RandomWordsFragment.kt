package com.eosdev.linguallexicon.ui.random

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.eosdev.linguallexicon.data.model.Word
import com.eosdev.linguallexicon.databinding.FragmentRandomWordsBinding
import com.eosdev.linguallexicon.ui.words.adapter.WordsAdapter
import com.eosdev.linguallexicon.ui.words.viewmodel.WordsViewModel
import com.google.gson.Gson


class RandomWordsFragment : Fragment() {

    private lateinit var binding: FragmentRandomWordsBinding
    private val viewModel: WordsViewModel by viewModels()
    private lateinit var adapter: WordsAdapter
    private var fullWordList: List<Word> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRandomWordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeAdapter()
        setUpRecyclerView()
        observeViewModel()
        setUpSearchView()

        binding.swipeRefreshLayout.setOnRefreshListener {
            refreshWordList()
        }
    }

    private fun initializeAdapter() {
        adapter = WordsAdapter(emptyList()) { wordModel ->
            navigateToRandomWordDetail(wordModel)
        }
    }

    private fun setUpRecyclerView() {
        binding.rvWordsList.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvWordsList.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.randomWords.observe(viewLifecycleOwner) { wordList ->
            fullWordList = filterLearnedWords(wordList ?: emptyList())
            updateAdapter(fullWordList)
        }
    }

    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                filterWords(newText)
                return true
            }
        })
    }

    private fun filterWords(query: String?) {
        val filteredList = if (!query.isNullOrEmpty()) {
            fullWordList.filter {
                it.englishName.contains(query, ignoreCase = true) || it.turkishName.contains(
                    query, ignoreCase = true
                )
            }
        } else {
            fullWordList
        }
        updateAdapter(filteredList)
    }

    private fun updateAdapter(newWordList: List<Word>) {
        adapter.wordList = newWordList
        adapter.notifyDataSetChanged()
    }

    private fun filterLearnedWords(wordList: List<Word>): List<Word> {
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("learned_words", Context.MODE_PRIVATE)
        val learnedWordsJson = sharedPreferences.getString("learned_words_list", null)

        val learnedWords: List<Word> = learnedWordsJson?.let {
            Gson().fromJson(it, Array<Word>::class.java).toList()
        } ?: emptyList()

        return wordList.filterNot { learnedWords.contains(it) }
    }

    private fun refreshWordList() {
        viewModel.refreshWords()
        binding.swipeRefreshLayout.isRefreshing = false
    }

    private fun navigateToRandomWordDetail(word: Word) {
        val action =
            com.eosdev.linguallexicon.ui.random.RandomWordsFragmentDirections.actionRandomWordsToDetail(
                word
            )
        findNavController().navigate(action)
    }

    override fun onResume() {
        super.onResume()
        clearSearchView()
    }

    private fun clearSearchView() {
        binding.searchView.setQuery("", false)
        binding.searchView.clearFocus()
    }
}
