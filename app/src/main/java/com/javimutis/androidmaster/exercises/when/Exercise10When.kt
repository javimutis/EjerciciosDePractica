package com.javimutis.androidmaster.exercises.`when`
/* Explicación general del código:
Se crean operaciones en main() usando Triple

Cada Triple almacena un número, otro número y un operador en formato String.

Se prueban diferentes escenarios: suma, división, operador inválido y división por 0.

Se usa la función printOperationResult() para procesar cada operación.

Se extraen los valores de Triple usando desestructuración.

Se utiliza when para realizar la operación matemática correspondiente.

Se valida la división para evitar errores por dividir entre 0.

Se maneja el caso de operadores inválidos con un mensaje de error.

Se imprime el resultado en la consola con formato número operador número = resultado

Ejemplo: 5 + 3 = 8

Si la operación no es válida, muestra un mensaje como "Operador inválido" o "División por 0".

*/


/**
 * 📌 Calculadora básica con `when`
 *
 * Este programa realiza operaciones matemáticas básicas entre dos números.
 * Soporta los siguientes operadores:
 *  - "+" → Suma
 *  - "-" → Resta
 *  - "*" → Multiplicación
 *  - "/" → División (con validación para evitar división por cero)
 *
 * Si se ingresa un operador no válido, se muestra un mensaje de error.
 */

fun main() {
    // 📌 Se crean operaciones matemáticas usando `Triple`, que almacena tres valores:
    // - Primer número
    // - Segundo número
    // - Operador matemático en formato String
    val operation1 = Triple(5, 3, "+")  // 5 + 3
    val operation2 = Triple(-10, 2, "/") // -10 / 2
    val operation3 = Triple(2, 3, "ç")  // Operador inválido
    val operation4 = Triple(8, 0, "/")  // División por 0 (caso especial)

    // 📌 Llamamos a la función `printOperationResult` para mostrar el resultado de cada operación
    printOperationResult(operation1)
    printOperationResult(operation2)
    printOperationResult(operation3)
    printOperationResult(operation4)
}

/**
 * 📌 Función que recibe una operación y muestra su resultado.
 * @param operation Un `Triple<Int, Int, String>` con los dos números y el operador.
 */
fun printOperationResult(operation: Triple<Int, Int, String>) {
    // 📌 Desestructuramos el `Triple` para obtener los valores individuales
    val (firstNumber, secondNumber, operator) = operation

    // 📌 Evaluamos el operador usando `when` para realizar la operación correspondiente
    val result = when (operator) {
        "+" -> firstNumber + secondNumber  // Suma
        "-" -> firstNumber - secondNumber  // Resta
        "*" -> firstNumber * secondNumber  // Multiplicación
        "/" -> if (secondNumber != 0) firstNumber / secondNumber else "División por 0"
        // Si el segundo número es 0, se muestra un mensaje de error en lugar de dividir

        else -> "Operador inválido" // Si el operador no es válido, se muestra un mensaje de error
    }

    // 📌 Se imprime el resultado en la consola
    println("$firstNumber $operator $secondNumber = $result")
}
