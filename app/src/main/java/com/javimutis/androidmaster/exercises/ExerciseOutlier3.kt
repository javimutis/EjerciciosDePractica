package com.javimutis.androidmaster.exercises

/*Clasificación de películas
Crea un programa que clasifique películas según su duración:

- Cortometraje: menos de 40 minutos.
- Largometraje: entre 40 y 120 minutos.
- Película épica: más de 120 minutos.
- Un valor de -1 para indicar que la duración no es válida.
Completa la función movieClassification() para que el programa imprima la clasificación correspondiente.*/

fun main() {
    val shortFilm = 30
    val featureFilm = 90
    val epicFilm = 150
    val invalidFilm = -10

    println("The classification for a movie of $shortFilm minutes is ${movieClassification(shortFilm)}.")
    println("The classification for a movie of $featureFilm minutes is ${movieClassification(featureFilm)}.")
    println("The classification for a movie of $epicFilm minutes is ${movieClassification(epicFilm)}.")
    println("The classification for a movie of $invalidFilm minutes is ${movieClassification(invalidFilm)}.")
}

fun movieClassification(duration: Int): String {
    return when {
        duration in 0..39-> "Cortometraje"
        duration in 40..120->"Largometraje"
        duration > 120->"Pelicula Épica"
        else-> "-1. Duración Inválida"
    }
}