package com.javimutis.androidmaster.sintaxis

//Los arreglos son estructuras de datos que permiten almacenar y acceder a una colección de elementos de un mismo tipo.
// Secuencias de datos. Lo que juega en contra es que se debe saber el tamaño de la secuencia y son fijas.

//Indice 0-6
// Tamaño 7
fun main() {
    //Tamaños
    val weekDays = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

//    println(weekDays[0])
//    println(weekDays.size)

    if (weekDays.size >= 8) {
        println(weekDays[7])
    } else {
        //     println("El arreglo no tiene 8 elementos")

    }
    //Bucles para Arrays
    for (position in weekDays.indices) {
        //     println(weekDays[position])
    }
    //Si nos interesa la posición y el valor
    for ((position, value) in weekDays.withIndex()) {
    //    println("La posición $position contiene el valor $value")
    }
    for (weekDay in weekDays) {
     //   println("Ahora es $weekDay")
    }
}