package com.example.learnmath1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.learnmath1.R
import com.example.learnmath1.fragment.QuestionFragment

class QuestionActivity : AppCompatActivity() {
    lateinit var questionFragment: QuestionFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        questionFragment = QuestionFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.questionActivity, questionFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
}
