package com.example.learnmath1.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learnmath1.R
import com.example.learnmath1.adapter.SliderAdapter
import com.example.learnmath1.datasource.FirebaseHandle
import com.example.learnmath1.fragment.OnClickListener
import com.example.learnmath1.model.Question
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {
    private val firebaseHandle: FirebaseHandle = FirebaseHandle(this)

    private val onClickListener = object : OnClickListener {
        override fun onItemClick(position: Int) {
            Toast.makeText(baseContext, "position: $position", Toast.LENGTH_LONG).show()
//                startActivity(Intent(context, QuestionActivity::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        firebaseHandle.getDataByID("5ol2zfUKtazw9T6iTCAn")

        rvQuestion.layoutManager = LinearLayoutManager(baseContext, RecyclerView.VERTICAL, false)

        btnComplete.setOnClickListener(){
            startActivity(Intent(this, ResultActivity::class.java))
        }
    }

    fun onLoaded(questions: ArrayList<Question>) {
        val adapter = SliderAdapter(questions, onClickListener)
        rvQuestion.adapter = adapter

        adapter!!.notifyDataSetChanged()
    }

    fun onFail(exception: Exception) {

    }
}
