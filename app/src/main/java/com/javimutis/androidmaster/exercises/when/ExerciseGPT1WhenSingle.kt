package com.javimutis.androidmaster.exercises.`when`

/*Clasificación de temperaturas
Las temperaturas pueden variar mucho dependiendo de la estación y la región. Queremos clasificar las temperaturas en distintas categorías.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que clasifique la temperatura dada según estas reglas:

"Very cold" si la temperatura es menor a 0°C.
"Cold" si está entre 0°C y 15°C (inclusive).
"Warm" si está entre 16°C y 30°C (inclusive).
"Hot" si está entre 31°C y 40°C (inclusive).
"Extremely hot!" si es mayor a 40°C.

Imprimir:
The temperature -5°C is classified as: Very cold
The temperature 10°C is classified as: Cold
The temperature 25°C is classified as: Warm
The temperature 35°C is classified as: Hot
The temperature 45°C is classified as: Extremely hot!
 */

fun main() {
    val temp1 = -5
    val temp2 = 10
    val temp3 = 25
    val temp4 = 35
    val temp5 = 45

    println("The temperature $temp1°C is classified as: ${classifyTemperatureVerbose(temp1)}")
    println("The temperature $temp2°C is classified as: ${classifyTemperatureVerbose(temp2)}")
    println("The temperature $temp3°C is classified as: ${classifyTemperature(temp3)}")
    println("The temperature $temp4°C is classified as: ${classifyTemperature(temp4)}")
    println("The temperature $temp5°C is classified as: ${classifyTemperature(temp5)}")
}

// Aquí usamos una Single-Expression Function con `=` porque la función solo evalúa y
// retorna un valor sin realizar pasos adicionales.
fun classifyTemperature(temp: Int): String = when {
    temp < 0 -> "Very cold"      // Si la temperatura es menor a 0, retorna "Very cold"
    temp in 0..15 -> "Cold"      // Si está entre 0 y 15, retorna "Cold"
    temp in 16..30 -> "Warm"     // Si está entre 16 y 30, retorna "Warm"
    temp in 31..40 -> "Hot"      // Si está entre 31 y 40, retorna "Hot"
    else -> "Extremely hot!"     // Cualquier otro valor (mayor a 40) retorna "Extremely hot!"
}

// ❌ Cuando NO es recomendable usar Single-Expression Function (`=`):
// Si la función requiere más lógica (como imprimir mensajes o
// realizar cálculos previos), es mejor usar `{}` y `return`.

fun classifyTemperatureVerbose(temp: Int): String {
    println("Checking temperature...")  // Mensaje adicional antes de evaluar la temperatura

    // En este caso, es mejor usar `{}` y `return`, ya que la función no solo devuelve un valor,
    // sino que también ejecuta otra acción.
    return when {
        temp < 0 -> "Very cold"
        temp in 0..15 -> "Cold"
        temp in 16..30 -> "Warm"
        temp in 31..40 -> "Hot"
        else -> "Extremely hot!"
    }
}