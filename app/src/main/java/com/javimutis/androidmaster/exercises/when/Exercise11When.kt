package com.javimutis.androidmaster.exercises.`when`
/*Explicación general del código:
Se define una data class Triangle(val a: Int, val b: Int, val c: Int)

Esta clase nos permite almacenar los tres lados del triángulo de manera estructurada.

Se crea una lista de triángulos en main() con diferentes valores para probar el programa.

Se incluyen ejemplos de triángulos equiláteros, isósceles, escalenos y un caso inválido.

Se recorre la lista con forEach { printTriangleResult(it) }

Se envía cada triángulo a la función printTriangleResult().

La función printTriangleResult(triangle: Triangle) analiza el tipo de triángulo

Primero, verifica si los lados cumplen la regla de la desigualdad triangular (la suma de dos lados debe ser mayor al tercer lado).

Luego, usa when para clasificar el triángulo según la cantidad de lados iguales.

Finalmente, imprime el resultado en la consola.

*/

/**
 * 📌 Clasificación de triángulos
 *
 * Este programa recibe los tres lados de un triángulo y determina su tipo:
 *  - Equilátero: todos los lados son iguales.
 *  - Isósceles: dos lados son iguales.
 *  - Escaleno: todos los lados son diferentes.
 *
 * Si los valores no pueden formar un triángulo (no cumplen la desigualdad triangular),
 * se muestra un mensaje de error.
 */

/**
 * 📌 Definimos una data class `Triangle` para representar un triángulo con tres lados.
 */
data class Triangle(val a: Int, val b: Int, val c: Int)

fun main() {
    // Lista de triángulos con diferentes combinaciones de lados
    val triangles = listOf(
        Triangle(3, 3, 3),  // Triángulo equilátero (todos los lados iguales)
        Triangle(3, 4, 4),  // Triángulo isósceles (dos lados iguales)
        Triangle(3, 4, 5),  // Triángulo escaleno (todos los lados diferentes)
        Triangle(1, 2, 10)  // No es un triángulo válido (no cumple la desigualdad triangular)
    )

    // Iteramos sobre la lista y analizamos cada triángulo con la función `printTriangleResult`
    triangles.forEach { printTriangleResult(it) }
}

/**
 * 📌 Función que analiza el tipo de triángulo y muestra el resultado en la consola.
 * @param triangle Un objeto de tipo `Triangle` con los tres lados.
 */
fun printTriangleResult(triangle: Triangle) {
    // Desestructuramos el objeto para obtener los lados `a`, `b` y `c`
    val (a, b, c) = triangle

    // Determinamos el tipo de triángulo utilizando `when`
    val result = when {
        // Verificamos si los lados NO forman un triángulo válido (Regla de la desigualdad triangular)
        a + b <= c || a + c <= b || b + c <= a -> "No es un triángulo válido"

        // Si los tres lados son iguales, es un triángulo equilátero
        a == b && b == c -> "Es un triángulo equilátero"

        // Si al menos dos lados son iguales, es un triángulo isósceles
        a == b || a == c || b == c -> "Es un triángulo isósceles"

        // Si todos los lados son diferentes, es un triángulo escaleno
        else -> "Es un triángulo escaleno"
    }

    // Imprimimos el resultado en la consola
    println("Lados: $a, $b, $c -> $result")
}
