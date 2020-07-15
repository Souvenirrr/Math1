package com.example.learnmath1.datasource

import android.content.ContentValues
import android.util.Log
import com.example.learnmath1.activity.QuestionActivity
import com.example.learnmath1.model.Question
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson

class FirebaseHandle(private val dataListener: QuestionActivity) {
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
                data.map {
                    val item = Gson().toJson(it).toString()
                    questions.add(Question.fromJson(item)!!)
                }
                dataListener.onLoaded(questions)
            }
            .addOnFailureListener { exception ->
                Log.d(ContentValues.TAG, "Error getting documents: ", exception)
                dataListener.onFail(exception)
            }
    }
}

interface DataListener {
    fun onLoaded(questions: List<Question>)
    fun onFail(exception: Exception)
}