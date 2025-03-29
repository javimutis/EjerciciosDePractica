package com.javimutis.androidmaster.exercises.`when`

/*Explicación general del código:
Se define una lista de calificaciones (grades) con valores numéricos.

Se recorre la lista con forEach y se llama a la función printEvaluation para cada calificación.

La función printEvaluation(grade: Int) toma una calificación y usa when para determinar su equivalente en letra.

Se imprimen los resultados en consola.*/

/**
 * 📌 Sistema de calificaciones con letras
 *
 * Este programa convierte calificaciones numéricas (0-100) en una calificación con letras.
 * Utiliza el sistema tradicional:
 *
 *  - 90 - 100 → A
 *  - 80 - 89 → B
 *  - 70 - 79 → C
 *  - 60 - 69 → D
 *  - Menos de 60 → F
 *
 * Si la calificación no está en el rango de 0 a 100, se mostrará un mensaje de error.
 */

fun main() {
    // Creamos una lista de calificaciones de ejemplo
    val grades = listOf(95, 83, 72, 50, 105)

    // Iteramos sobre la lista y llamamos a la función printEvaluation para cada calificación
    grades.forEach { printEvaluation(it) }
}

fun printEvaluation(grade: Int) {
    // Usamos una expresión 'when' para asignar la calificación en letras a la variable 'result'
    val result = when (grade) {
        in 90..100 -> "A"  // Si la calificación está entre 90 y 100, se asigna "A"
        in 80..89 -> "B"   // Si la calificación está entre 80 y 89, se asigna "B"
        in 70..79 -> "C"   // Si la calificación está entre 70 y 79, se asigna "C"
        in 60..69 -> "D"   // Si la calificación está entre 60 y 69, se asigna "D"
        in 0..59 -> "F"    // Si la calificación es menor a 60, se asigna "F"
        else -> "Error"    // Si el número no está en el rango de 0 a 100, se muestra "Error"
    }

    // Imprimimos la calificación en letras
    println("Tu calificación es $result")
}
