package com.example.learnmath1.model

import com.beust.klaxon.Klaxon

private val klaxon = Klaxon()

data class ListID (
    val data: List<Question>
) {

    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<ListID>(json)
    }
}