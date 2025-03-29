package com.javimutis.androidmaster.exercises.`when`

/**
 * Días de la semana (Fácil)
Crea un programa que reciba un número del 1 al 7 y devuelva el día de la semana correspondiente.
Por ejemplo:

1 → "Lunes"

7 → "Domingo"
Si el número no está en el rango válido, imprime "Número inválido".
 */
fun main() {
    val grade1 = 10
    val grade2 = 22
    val grade3 = 0
    val grade4 = 6
    val grade5 = -3

    printGrades(grade1)
    printGrades(grade2)
    printGrades(grade3)
    printGrades(grade4)
    printGrades(grade5)
}

fun printGrades(grade: Int) {

    val gradeDescription = when (grade) {
        in 0..3 -> "Reprobado"
        in 4..5 -> "Suficiente"
        in 6..7 -> "Bien"
        in 8..9 -> "Muy bien"
        10 -> "Excelente"
        else ->
            "Nota inválida"
    }
    println("Nota: $grade -> $gradeDescription")
}