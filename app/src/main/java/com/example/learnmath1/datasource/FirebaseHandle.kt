package com.example.learnmath1.datasource

import android.content.ContentValues
import android.util.Log
import com.beust.klaxon.JsonObject
import com.example.learnmath1.model.Content
import com.example.learnmath1.model.ListID
import com.example.learnmath1.model.Question
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson

class FirebaseHandle(private val dataListener: DataListener) {
    private val db = Firebase.firestore

    fun getDataByID(id: String) {
        var myDocument: QueryDocumentSnapshot? = null
        val questions: ArrayList<Question> = ArrayList()
        db.collection("problem")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    if (document.id == id) {
                        myDocument = document
                        break
                    }
                }
                val data = myDocument!!["data"] as ArrayList<*>
                data.map { it ->
                    val item = Gson().toJson(it).toString()
                    Log.d("ddd", item)
                    questions.add(Question.fromJson(item)!!)
                }
                Log.d("question ", questions.toString())
                //dataListener.onLoaded(ListID(data))
            }
            .addOnFailureListener { exception ->
                Log.d(ContentValues.TAG, "Error getting documents: ", exception)
            }
    }
}

interface DataListener {
    fun onLoaded(questions: List<Question>)
    fun onFail()
}