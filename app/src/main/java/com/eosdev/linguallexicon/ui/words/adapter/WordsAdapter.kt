package com.eosdev.linguallexicon.ui.words.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eosdev.linguallexicon.data.model.Word
import com.eosdev.linguallexicon.databinding.ItemWordBinding

class WordsAdapter(
    var wordList: List<Word>, private val onClickListener: (Word) -> Unit
) : RecyclerView.Adapter<WordsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val binding =
            ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        val wordModel = wordList[position]
        holder.bind(wordModel, onClickListener)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }




}