package com.javimutis.androidmaster.exercises.`when`

/**
 * Clasificación de triángulos
📌 Descripción:
Crea un programa que reciba tres lados de un triángulo y determine qué tipo de triángulo es:

Equilátero: todos los lados son iguales.

Isósceles: dos lados son iguales.

Escaleno: todos los lados son diferentes.
Si los valores no pueden formar un triángulo, muestra un mensaje de error. */

data class Triangle(val a: Int, val b: Int, val c: Int)

fun main() {
    val triangles = listOf(
        Triangle(3, 3, 3),
        Triangle(3, 4, 4),
        Triangle(3, 4, 5),
        Triangle(1, 2, 10)
    )

    triangles.forEach { printTriangleResult(it) }

}

fun printTriangleResult(triangle: Triangle) {
    val (a, b, c) = triangle

    val result = when {
        a + b <= c || a + c <= b || b + c <= a -> "No es un triángulo válido"
        a == b && b == c -> "Es un triángulo equilátero"
        a == b || a == c || b == c -> "Es un triángulo isóceles"
        else -> "Es un triángulo escaleno"
    }
    println("Lados: $a, $b, $c -> $result")
}