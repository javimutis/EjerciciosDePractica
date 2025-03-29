package com.javimutis.androidmaster.exercises.`when`

/* Clasificación de estudiantes
Crea un programa que clasifique a los estudiantes según su calificación.
 Las calificaciones se dividen de la siguiente manera:

A: 90-100
B: 80-89
C: 70-79
D: 60-69
F: 0-59
Un valor de -1 para indicar que la calificación no es válida.*/
fun main() {
    val student1 = 95
    val student2 = 85
    val student3 = 72
    val student4 = 58
    val student5 = -5

    println("The grade for a score of $student1 is ${gradeClassification(student1)}.")
    println("The grade for a score of $student2 is ${gradeClassification(student2)}.")
    println("The grade for a score of $student3 is ${gradeClassification(student3)}.")
    println("The grade for a score of $student4 is ${gradeClassification(student4)}.")
    println("The grade for a score of $student5 is ${gradeClassification(student5)}.")
}

fun gradeClassification(score: Int): String {
//Se utiliza return para poder manejar el valos negativo que se explicita en el ejercicio,
    // utilizar solo when no permite eso
    return when {
        score < 0 -> "Invalid grade"
        score in 0..59 -> "F"
        score in 60..69 -> "D"
        score in 70..79 -> "C"
        score in 80..89 -> "B"
        score in 90..100 -> "A"
        else -> "Unreal"
    }
}