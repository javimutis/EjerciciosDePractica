package com.javimutis.androidmaster.exercises.classes

/*A menudo, debes completar los perfiles de sitios web en línea que contienen campos obligatorios
y no obligatorios. Por ejemplo, puedes agregar tu información personal y un vínculo a otras personas
que te refirieron para que registraras tu perfil.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa
que imprima los detalles del perfil de una persona.

IMPRIMIR:
Name: Amanda
Age: 33
Likes to play tennis. Doesn't have a referrer.

Name: Atiqah
Age: 28
Likes to climb. Has a referrer named Amanda, who likes to play tennis.
 */
fun main() {
    // Creamos una instancia de Person llamada "amanda"
    // No tiene un referrer (último parámetro es null)
    val amanda = Person("Amanda", 33, "play tennis", null)

    // Creamos otra instancia de Person llamada "atiqah"
    // Su referrer es "amanda" (último parámetro)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    // Llamamos al método showProfile() para imprimir la información de Amanda
    amanda.showProfile()

    // Llamamos al método showProfile() para imprimir la información de Atiqah
    atiqah.showProfile()
}

// Definimos la clase Person con sus propiedades
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {

    // Método para mostrar el perfil de la persona
    fun showProfile() {
        // Verificamos si la persona tiene un referrer
        if (referrer != null) {
            // Si tiene un referrer, imprimimos su información incluyendo su nombre y hobby
            println("Name: $name\nAge: $age\nLikes to $hobby. Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}.")
        } else {
            // Si no tiene un referrer, imprimimos un mensaje indicando que no tiene uno
            println("Name: $name\nAge: $age\nLikes to $hobby. Doesn't have a referrer.")
        }
    }
}
