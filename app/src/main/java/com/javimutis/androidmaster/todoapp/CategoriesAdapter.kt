package com.javimutis.androidmaster.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javimutis.androidmaster.R

// Esta clase es un adaptador para un RecyclerView que maneja las categorías de tareas
class CategoriesAdapter(private val categories: List<TaskCategory>, private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<CategoriesViewHolder>() {

    // Esta función se llama cuando se crea una nueva vista (ViewHolder) para un item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        // Se infla el layout que representa un item (una categoría)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        // Se retorna un CategoriesViewHolder, que es el encargado de manejar la vista de cada item
        return CategoriesViewHolder(view)
    }

    // Esta función se llama para asignar los datos a cada item del RecyclerView
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        // Se pasa la categoría de la lista al ViewHolder para que la renderice
        holder.render(categories[position], onItemSelected)
    }

    // Esta función devuelve la cantidad de elementos en la lista de categorías
    override fun getItemCount(): Int = categories.size
}