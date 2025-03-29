package com.javimutis.androidmaster.exercises.`when`
/*Explicación general del código:
Se define una lista de temperaturas con valores en Celsius y su código de conversión (temperatures).

Se recorre la lista con forEach y se llama a printTemperature(temp, unit).

La función printTemperature(grade: Double, type: String) convierte la temperatura según el código usando when.

Se usa type.uppercase() para aceptar tanto mayúsculas como minúsculas en la entrada.

Si el código es inválido, se muestra un mensaje de error.

El resultado de la conversión se imprime en la consola.*/


/**
 * 📌 Conversor de unidades de temperatura
 *
 * Este programa convierte temperaturas de grados Celsius a otras unidades de medida:
 *  - "K" → Kelvin
 *  - "F" → Fahrenheit
 *  - "R" → Rankine
 *
 * Si el usuario ingresa un código incorrecto, se muestra un mensaje de error.
 *
 * 📌 Fórmulas de conversión:
 *  - Kelvin = Celsius + 273.15
 *  - Fahrenheit = (Celsius × 9/5) + 32
 *  - Rankine = (Celsius + 273.15) × 9/5
 */

fun main() {
    // Lista de temperaturas con su código de conversión (Ej: 25°C a Kelvin, -10°C a Fahrenheit, etc.)
    val temperatures = listOf(
        Pair(25.0, "K"),  // Convertir 25°C a Kelvin
        Pair(-10.0, "F"), // Convertir -10°C a Fahrenheit
        Pair(100.0, "R"), // Convertir 100°C a Rankine
        Pair(30.0, "X")   // Código inválido para probar el manejo de errores
    )

    // Iteramos sobre la lista y llamamos a printTemperature con cada temperatura y su código de conversión
    temperatures.forEach { (temp, unit) -> printTemperature(temp, unit) }
}

/**
 * 📌 Función para convertir y mostrar la temperatura
 * @param celsius Temperatura en grados Celsius
 * @param type Código de conversión ("K", "F" o "R")
 */
fun printTemperature(celsius: Double, type: String) {
    // Utilizamos `when` para determinar el tipo de conversión
    val result = when (type.uppercase()) { // Convertimos el código a mayúsculas para evitar errores de entrada
        "K" -> "$celsius°C = ${celsius + 273.15}°K" // Conversión a Kelvin
        "F" -> "$celsius°C = ${(celsius * 9 / 5) + 32}°F" // Conversión a Fahrenheit
        "R" -> "$celsius°C = ${(celsius + 273.15) * 9 / 5}°R" // Conversión a Rankine
        else -> "Código inválido" // Mensaje de error si el código ingresado no es válido
    }

    // Imprimimos el resultado de la conversión o el mensaje de error
    println(result)
}
