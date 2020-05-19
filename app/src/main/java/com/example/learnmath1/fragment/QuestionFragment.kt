package com.example.learnmath1.fragment

import android.os.Bundle
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
    }

    override fun onLoaded(questions: List<Question>) {
        //tvQuestion.text = listID.data[0].question

    }


    override fun onFail() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
