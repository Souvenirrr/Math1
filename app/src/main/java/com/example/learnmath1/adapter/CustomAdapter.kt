package com.example.learnmath1.adapter

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learnmath1.R
import com.example.learnmath1.model.Problem

class CustomAdapter(private val problemList : ArrayList<Problem>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val mathID = itemView.findViewById(R.id.mathID) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return problemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val problem : Problem = problemList[position]

        holder?.mathID?.text = problem.name // name is title problem of list
    }
}
