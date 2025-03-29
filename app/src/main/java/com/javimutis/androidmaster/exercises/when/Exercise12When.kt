package com.javimutis.androidmaster.exercises.`when`

/**
 * Conversor de unidades de temperatura
📌 Descripción:
Crea un programa que reciba una temperatura en grados Celsius y un código de conversión:

"K" para convertir a Kelvin.

"F" para convertir a Fahrenheit.

"R" para convertir a Rankine.
Si el código ingresado no es válido, muestra un mensaje de error.

📌 Fórmulas de conversión:

Kelvin = Celsius + 273.15

Fahrenheit = (Celsius × 9/5) + 32

Rankine = (Celsius + 273.15) × 9/5*/

fun main() {
    val temperatures = listOf(
        Pair(25.0, "K"),
        Pair(-10.0, "F"),
        Pair(100.0, "R"),
        Pair(30.0, "X")
    )

    temperatures.forEach { (temp, unit) -> printTemperature(temp, unit) }
}

fun printTemperature(celsius: Double, type: String) {
    val result = when (type.uppercase()) {
        "K" -> "$celsius°C = ${celsius + 273.15}°K"
        "F" -> "$celsius°C = ${(celsius * 9 / 5) + 32}°F"
        "R" -> "$celsius°C = ${(celsius + 273.15) * 9 / 5}°R"
        else -> "Código inválido"
    }

    println(result)
}