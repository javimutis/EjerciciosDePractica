package com.javimutis.androidmaster

//Los arreglos son estructuras de datos que permiten almacenar y acceder a una colección de elementos de un mismo tipo.
// Secuencias de datos.

//Indice 0-6
// Tamaño 7
fun main() {
    //Tamaños
    val weekDays = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

    println(weekDays[0])
    println(weekDays.size)

    if (weekDays.size >= 8) {
        println(weekDays[7])
    } else {
        println("El arreglo no tiene 8 elementos")

    }
    //Bucles para Arrays
    for (position in weekDays.indices) {
        println(weekDays[position])
    }
    for ((position, value) in weekDays.withIndex()) {
    }
}