package com.example.learnmath1.fragment

import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.learnmath1.R
import com.example.learnmath1.activity.QuestionActivity
import com.example.learnmath1.adapter.SliderAdapter
import com.example.learnmath1.datasource.DataListener
import com.example.learnmath1.datasource.FirebaseHandle
import com.example.learnmath1.model.Answer
import com.example.learnmath1.model.ListID
import com.example.learnmath1.model.Problem
import com.example.learnmath1.model.Question
import kotlinx.android.synthetic.main.fragment_question.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment(), DataListener {
    val q = ArrayList<Question>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // TODO recycle view handling

        val adapter = SliderAdapter(q, onClickListener)

        rvQuestion.adapter = adapter
    }

    private val onClickListener = object : OnClickListener {
        override fun onItemClick(position: Int) {
            Toast.makeText(context, "position: $position", Toast.LENGTH_LONG).show()
//                startActivity(Intent(context, QuestionActivity::class.java))
        }
    }

    override fun onLoaded(questions: List<Question>) {
        Log.d("question", questions.toString())
        for (i in 0 until 10) {
            q.add(
                Question(
                    Answer(
                        q[i].answer.value1,
                        q[i].answer.value2,
                        q[i].answer.value3,
                        q[i].answer.value4,
                        q[i].answer.correct
                    ), q[i].question
                )
            )
        }
    }

    override fun onFail(exception: Exception) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
