package com.example.learnmath1.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnmath1.R
import com.example.learnmath1.adapter.SliderAdapter
import com.example.learnmath1.datasource.DataListener
import com.example.learnmath1.model.Question
import kotlinx.android.synthetic.main.activity_question.*


class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val pagerAdapter = SliderAdapter(supportFragmentManager)
        viewQuestion.adapter = pagerAdapter
    }

    override fun onBackPressed() {
        if (viewQuestion.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewQuestion.currentItem = viewQuestion.currentItem - 1
        }
    }
}
