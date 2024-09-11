package com.eosdev.linguallexicon.data.model

import java.io.Serializable

data class Word(
    val id: Int,
    val englishName: String,
    val image: Int,
    val englishSentence:String,
    val turkishSentence:String,
    val turkishName: String,
    var isLearned: Boolean = false
) : Serializable

