package com.javimutis.androidmaster.exercises.`when`

fun main() {
    val operation1 = Triple(5, 3, "+")
    val operation2 = Triple(-10, 2, "/")
    val operation3 = Triple(2, 3, "ç")
    val operation4 = Triple(8, 0, "/")

    printOperationResult(operation1)
    printOperationResult(operation2)
    printOperationResult(operation3)
    printOperationResult(operation4)
}

fun printOperationResult(operation: Triple<Int, Int, String>) {
    val (firstNumber, secondNumber, operator) = operation

    val result = when (operator) {
        "+" -> firstNumber + secondNumber
        "-" -> firstNumber - secondNumber
        "*" -> firstNumber * secondNumber
        "/" -> if (secondNumber != 0) firstNumber / secondNumber else "División por 0"
        else -> "Operador inválido"
    }
    println("$firstNumber $operator $secondNumber = $result")
}