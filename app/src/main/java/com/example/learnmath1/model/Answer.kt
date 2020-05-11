package com.example.learnmath1.model

import com.beust.klaxon.Klaxon

private val klaxon = Klaxon()

data class Answer(
    val value1: Long,
    val value2: Long,
    val value3: Long,
    val value4: Long,
    val correct: Long

)