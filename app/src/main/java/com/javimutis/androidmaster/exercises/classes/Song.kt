package com.javimutis.androidmaster.exercises.classes

// Definimos la clase Song con las propiedades requeridas
class Song(val title: String, val artist: String, val year: Int, val reproductions: Int) {

    // Propiedad calculada que indica si la canción es popular o no
    val isPopular: Boolean
        get() = reproductions >= 1000

    // Método para imprimir la descripción de la canción
    fun printDescription() {
        println("$title, interpretada por $artist, se lanzó en $year.")
    }
}
