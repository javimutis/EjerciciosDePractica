package com.javimutis.androidmaster.exercises.ifElse

/*Ejercicio 1: Verificación de mayoría de edad (Fácil)
Escribe un programa que pida la edad de una persona y determine
si es mayor de edad (18 años o más) o menor de edad.
El programa debe imprimir un mensaje adecuado según la condición.*/

fun main() {
    val age1 = 20
    val age2 = 15
    val age3 = 18

    printPersonAge(age1)
    printPersonAge(age2)
    printPersonAge(age3)

}

fun printPersonAge(personAge: Int) {
    println("Ingrese su edad: $personAge")

    if (personAge >= 18) {
        println("Eres mayor de edad.")
    } else {
        println("Eres menor de edad.")
    }
}
