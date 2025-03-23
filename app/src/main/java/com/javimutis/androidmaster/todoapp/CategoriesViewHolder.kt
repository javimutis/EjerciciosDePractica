package com.javimutis.androidmaster.todoapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.javimutis.androidmaster.R

// Esta clase es un ViewHolder para las categorías de tareas, que es utilizada por un RecyclerView
class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // Se definen las vistas que se utilizarán para mostrar la categoría
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName) // Nombre de la categoría
    private val divider: View = view.findViewById(R.id.divider) // Línea divisoria
    private val viewContainer: CardView = view.findViewById(R.id.viewContainer) // Contenedor con fondo

    // Esta función se llama para mostrar los datos de una categoría
    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        // Determina el color del fondo de la tarjeta según si la categoría está seleccionada o no
        val color =
            if (taskCategory.isSelected) {
                R.color.todo_background_card // Color para categorías seleccionadas
            } else {
                R.color.todo_background_disabled // Color para categorías no seleccionadas
            }

        // Aplica el color al fondo de la tarjeta (CardView)
        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context, color))

        // Asigna un listener a la vista que llamará la función 'onItemSelected' cuando se haga clic
        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        // Dependiendo del tipo de categoría (Business, Personal, Other), cambia el texto y color del divisor
        when (taskCategory) {
            TaskCategory.Business -> {
                tvCategoryName.text = "Negocios" // Nombre para la categoría de Negocios
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_business_category) // Color del divisor para 'Negocios'
                )
            }

            TaskCategory.Other -> {
                tvCategoryName.text = "Otros" // Nombre para la categoría de Otros
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_other_category) // Color del divisor para 'Otros'
                )
            }

            TaskCategory.Personal -> {
                tvCategoryName.text = "Personal" // Nombre para la categoría Personal
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_personal_category) // Color del divisor para 'Personal'
                )
            }
        }
    }
}