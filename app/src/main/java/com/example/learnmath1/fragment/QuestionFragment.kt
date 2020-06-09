package com.example.learnmath1.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.learnmath1.R
import com.example.learnmath1.datasource.DataListener
import com.example.learnmath1.datasource.FirebaseHandle
import com.example.learnmath1.model.ListID
import com.example.learnmath1.model.Question
import kotlinx.android.synthetic.main.fragment_question.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment(), DataListener {
    private val firebaseHandle: FirebaseHandle = FirebaseHandle(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseHandle.getDataByID("5ol2zfUKtazw9T6iTCAn")
        // TODO recycle view handling
    }

    override fun onLoaded(questions: List<Question>) {
        Log.d("question", questions.toString())
        for (i in 0 until 2) {
            tvQuestion.text = questions[i].question
            radA.text = questions[i].answer.value1.toString()
            radB.text = questions[i].answer.value2.toString()
            radC.text = questions[i].answer.value3.toString()
            radD.text = questions[i].answer.value4.toString()
        }
    }

    override fun onFail(exception: Exception) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
