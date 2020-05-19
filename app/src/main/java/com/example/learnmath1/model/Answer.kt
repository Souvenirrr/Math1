package com.example.learnmath1.model

import com.beust.klaxon.Klaxon

private val klaxon = Klaxon()

data class Answer (
    val value1: Int? = null,
    val value2: Int? = null,
    val value3: Int? = null,
    val value4: Int? = null,
    val correct: Int? = null
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Answer>(json)
    }
}