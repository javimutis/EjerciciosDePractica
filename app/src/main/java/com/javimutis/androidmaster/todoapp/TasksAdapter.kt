package com.javimutis.androidmaster.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javimutis.androidmaster.R

// Adapter para la lista de tareas en un RecyclerView
class TasksAdapter(
    var tasks: List<Task>,  // Lista de tareas que se mostrarán en la lista
    private val onTaskSelected: (Int) -> Unit // Función que se ejecuta cuando se selecciona una tarea
) : RecyclerView.Adapter<TasksViewHolder>() { // Extiende de RecyclerView.Adapter y usa TasksViewHolder

    // Método que crea un nuevo ViewHolder cuando el RecyclerView lo necesita
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        // Infla el diseño del item (item_todo_task.xml) y lo convierte en una vista
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TasksViewHolder(view) // Retorna un ViewHolder con la vista inflada
    }

    // Devuelve la cantidad de elementos en la lista de tareas
    override fun getItemCount() = tasks.size

    // Método que se llama cuando se debe mostrar un elemento en una posición específica
    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        // Llama al método render() del ViewHolder para mostrar los datos de la tarea en esa posición
        holder.render(tasks[position])

        // Agrega un listener para detectar cuando el usuario toca un elemento de la lista
        holder.itemView.setOnClickListener {
            onTaskSelected(position) // Ejecuta la función onTaskSelected pasando la posición de la tarea seleccionada
        }
    }
}
