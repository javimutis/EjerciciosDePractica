package com.javimutis.androidmaster.todoapp

// Se define una clase de datos (data class) llamada Task para representar una tarea
data class Task(
    val name: String,             // Nombre de la tarea
    val category: TaskCategory,   // Categoría de la tarea (Personal, Business u Other)
    var isSelected: Boolean = false // Indica si la tarea está marcada como completada o seleccionada (por defecto, false)
)
