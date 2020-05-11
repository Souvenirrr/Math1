package com.example.learnmath1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learnmath1.R
import com.example.learnmath1.fragment.OnClickListener
import com.example.learnmath1.model.Problem

class QuestionListAdapter(
    private val problemList: ArrayList<Problem>,
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<QuestionListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mathID = itemView.findViewById(R.id.mathID) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return problemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val problem: Problem = problemList[position]

        holder?.mathID?.text = problem.name // name is title problem of list

        holder.itemView.setOnClickListener {
            onClickListener.onItemClick(position)
        }
    }
}


