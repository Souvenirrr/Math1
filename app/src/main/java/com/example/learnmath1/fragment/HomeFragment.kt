package com.example.learnmath1.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learnmath1.R
import com.example.learnmath1.activity.QuestionActivity
import com.example.learnmath1.adapter.CustomAdapter
import com.example.learnmath1.model.Problem
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvProblem.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        val problem = ArrayList<Problem>()

        problem.add(Problem("Đề số 1"))
        problem.add(Problem("Đề số 2"))
        problem.add(Problem("Đề số 3"))
        problem.add(Problem("Đề số 4"))
        problem.add(Problem("Đề số 5"))
        problem.add(Problem("Đề số 6"))
        problem.add(Problem("Đề số 7"))
        problem.add(Problem("Đề số 8"))

        val adapter = CustomAdapter(context,problem, onClickListener)

        rvProblem.adapter = adapter
    }

    private val onClickListener = object : OnClickListener {
        override fun onItemClick(position: Int) {
            Toast.makeText(context, "position: $position", Toast.LENGTH_LONG).show()
            startActivity(Intent(context, QuestionActivity::class.java))
        }
    }
}
interface OnClickListener {
    fun onItemClick(position: Int)
}
