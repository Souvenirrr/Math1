package com.example.learnmath1.datasource

import android.content.ContentValues
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirebaseHandle {
    private val db = Firebase.firestore

    fun getData(){
        db.collection("problem")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("dm1", "dm")
                    Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("dm2", "dm")
                Log.d(ContentValues.TAG, "Error getting documents: ", exception)
            }
        Log.d("dm", "dm")
    }
}