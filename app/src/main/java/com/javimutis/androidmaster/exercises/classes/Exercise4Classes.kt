package com.javimutis.androidmaster.exercises.classes

/*
Biblioteca de Libros 📚
Imagina que estás desarrollando una app para gestionar una biblioteca personal.

Instrucciones:
Crea una clase Book que tenga:
✅ Propiedades:
- title: el título del libro (String).
- author: el autor del libro (String).
- year: el año de publicación (Int).
- isRead: indica si el libro ha sido leído (Boolean).
✅ Métodos:
printDescription(): Imprime una descripción en este formato:
- 📖 "[Título]" de [Autor], publicado en [Año].
- Si el libro ha sido leído: "Ya lo has leído."
- Si no ha sido leído: "Aún no lo has leído."
markAsRead(): Cambia el estado de isRead a true.*/

fun main() {
    val book1 = Book("Cien años de soledad", "Gabriel García Márquez", 1967, false)
    val book2 = Book("1984", "George Orwell", 1949, true)

    book1.printDescription()
    book1.markAsRead()
    book1.printDescription()

    book2.printDescription()
}

class Book(val title: String, val author: String, val year: Int, var isRead: Boolean) {
    // Función que imprime la descripción del libro
    fun printDescription() {
        val readStatus = if (isRead) "Ya lo has leído." else "Aún no lo has leído."
        println("\"$title\" de $author, publicado en $year. $readStatus")
    }

    // Función que marca el libro como leído
    fun markAsRead() {
        if (!isRead) {
            isRead = true
        } else {
            println("El libro \"$title\" ya estaba marcado como leído.")
        }
    }
}
