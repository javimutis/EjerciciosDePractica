package com.javimutis.androidmaster.todoapp

import android.view.View
import android.widget.TextView
import android.widget.CheckBox

import androidx.recyclerview.widget.RecyclerView
import com.javimutis.androidmaster.R

class TasksViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    private val tvTask: TextView = view.findViewById(R.id.tvTask)
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask)
    fun render(task: Task) {
        tvTask.text = task.name

    }
}