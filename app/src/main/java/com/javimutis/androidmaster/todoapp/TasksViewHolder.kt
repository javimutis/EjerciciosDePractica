package com.javimutis.androidmaster.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.javimutis.androidmaster.R

// ViewHolder para gestionar la visualización de tareas en la lista
class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Referencias a los elementos de la vista dentro del ViewHolder
    private val tvTask: TextView = view.findViewById(R.id.tvTask)
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask)

    // Método para actualizar la vista con los datos de una tarea específica
    fun render(task: Task) {
        // Aplica o elimina el tachado en el texto de la tarea según si está seleccionada
        if (task.isSelected) {
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        // Asigna el nombre de la tarea al TextView
        tvTask.text = task.name

        // Marca o desmarca el CheckBox según el estado de la tarea
        cbTask.isChecked = task.isSelected

        // Asigna un color al CheckBox según la categoría de la tarea
        val color = when (task.category) {
            TaskCategory.Business -> R.color.todo_business_category
            TaskCategory.Other -> R.color.todo_other_category
            TaskCategory.Personal -> R.color.todo_personal_category
        }

        // Aplica el color de la categoría al CheckBox
        cbTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTask.context, color)
        )
    }
}
