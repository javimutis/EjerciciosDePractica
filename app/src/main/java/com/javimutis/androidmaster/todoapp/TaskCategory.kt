package com.javimutis.androidmaster.todoapp

// Clase sellada (sealed) que representa las categorías de una tarea
// Se usa una clase sellada porque permite definir un conjunto fijo de categorías
sealed class TaskCategory(var isSelected: Boolean = true) {

    // Se definen tres categorías de tareas como objetos dentro de la clase sellada
    object Personal : TaskCategory()  // Categoría de tareas personales
    object Business : TaskCategory()  // Categoría de tareas de negocios o trabajo
    object Other : TaskCategory()     // Categoría para otras tareas

}
