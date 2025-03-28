package com.javimutis.androidmaster.exercises.classes

/*Crea una clase que pueda representar la estructura de una canción. La clase Song debe incluir estos elementos de código:

Propiedades para el título, el artista, el año de publicación y el recuento de reproducciones
Propiedad que indica si la canción es popular (si el recuento de reproducciones es inferior a 1,000, considera que es poco popular)
Un método para imprimir la descripción de una canción en este formato:
"[Título], interpretada por [artista], se lanzó en [año de lanzamiento]".*/

// Función principal para probar la clase Song
fun main() {
    // Creamos una instancia de la clase Song
    val song = Song("Bohemian Rhapsody", "Queen", 1975, 1000)

    // Llamamos al método para imprimir la descripción
    song.printDescription()

    // Verificamos si la canción es popular
    println("¿Es popular? ${song.isPopular}")
}


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
