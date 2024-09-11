package com.eosdev.linguallexicon.ui.words.adapter

import androidx.recyclerview.widget.RecyclerView
import com.eosdev.linguallexicon.data.model.Word
import com.eosdev.linguallexicon.databinding.ItemLayoutWordsListBinding


class WordsViewHolder(private val binding: ItemLayoutWordsListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(word: Word, onClickListener: (Word) -> Unit) {
        binding.tvEnglishWordName.text = word.englishName
        binding.tvTurkishWordName.text = word.turkishName
        binding.ivWord.setImageResource(word.image)

        binding.root.setOnClickListener {
            onClickListener.invoke(word)
        }
    }
}