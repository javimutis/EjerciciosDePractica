package com.javimutis.androidmaster.exercises.ifElse

/*Clasificación de números (Intermedio)
Crea un programa que solicite un número al usuario y clasifique si es positivo, negativo o cero.*/
/*En este ejercicio se debiese utilizar When*/
fun main() {
    val number1 = 10
    val number2 = -5
    val number3 = 0

    printNumber(number1)
    printNumber(number2)
    printNumber(number3)

}

fun printNumber(number: Int) {
    println("Ingrese un número: $number.")
    if (number == 0)
        println("El número es cero.")
    else if (number > 0)
        println("El número es positivo.")
    else
        println("El número es negativo.")
}

