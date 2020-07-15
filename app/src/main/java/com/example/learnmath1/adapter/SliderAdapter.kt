package com.example.learnmath1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learnmath1.R
import com.example.learnmath1.fragment.OnClickListener
import com.example.learnmath1.model.Question

private const val NUM_PAGES = 10

class SliderAdapter(
    private val question: List<Question>,
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvQuestion = itemView.findViewById(R.id.tvQuestion) as TextView
        val tvNum = itemView.findViewById(R.id.tvNum) as TextView
        val rad = itemView.findViewById(R.id.radGroup) as RadioGroup
        val radA = itemView.findViewById(R.id.radA) as RadioButton
        val radB = itemView.findViewById(R.id.radB) as RadioButton
        val radC = itemView.findViewById(R.id.radC) as RadioButton
        val radD = itemView.findViewById(R.id.radD) as RadioButton
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return question.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content : Question = question[position]

        holder?.tvNum?.text = "Câu ${position + 1}"
        holder?.tvQuestion?.text = content.question
        holder?.radA?.text = content.answer.value1.toString()
        holder?.radB?.text = content.answer.value2.toString()
        holder?.radC?.text = content.answer.value3.toString()
        holder?.radD?.text = content.answer.value4.toString()

        holder.rad.checkedRadioButtonId
    }
}