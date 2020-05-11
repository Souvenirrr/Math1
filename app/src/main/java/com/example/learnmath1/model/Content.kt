package com.example.learnmath1.model

import com.beust.klaxon.Klaxon

private val klaxon = Klaxon()

data class Content (
    val question: String,
    val answer: Answer
){
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Content>(json)
    }
}