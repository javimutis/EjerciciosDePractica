package com.javimutis.androidmaster.exercises.`when`

/**
 * Sistema de calificaciones con letras
📌 Descripción:
Crea un programa que reciba una calificación numérica (0-100) y devuelva su equivalente en letra según el sistema tradicional:

90 - 100 → A

80 - 89 → B

70 - 79 → C

60 - 69 → D

Menos de 60 → F
Si el número está fuera de este rango, muestra un mensaje de error. */

fun main() {
    val grades = listOf(95, 83, 72, 50, 105)

    grades.forEach { printEvaluation(it) }

}

fun printEvaluation(grade: Int) {

    val result = when (grade) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        in 0..59 -> "F"
        else -> "Error"
    }
    println("Tu calificación es $result")
}