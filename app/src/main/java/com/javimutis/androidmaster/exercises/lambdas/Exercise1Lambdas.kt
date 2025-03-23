package com.javimutis.androidmaster.exercises.lambdas

//Sintaxis básica de una lambda: { parámetro -> cuerpo de la función }.
//En el caso de la conversión de temperatura, cada lambda toma un número (Double) como parámetro y realiza una operación matemática para convertirlo.

/*Conversor de temperatura
En el mundo, se usan tres escalas de temperatura principales: Celsius, Fahrenheit y Kelvin.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que
convierta una temperatura de una escala a otra con estas fórmulas:

- De grados Celsius a Fahrenheit: °F = 9/5 (°C) + 32
- Kelvin a Celsius: °C = K - 273.15
- De Fahrenheit a Kelvin: K = 5/9 (°F - 32) + 273.15
- Ten en cuenta que el método String.format("%.2f", /* measurement */ ) se usa para convertir un
 número en un tipo String con 2 decimales.


RESULTADO:
27.0 degrees Celsius is 80.60 degrees Fahrenheit.
350.0 degrees Kelvin is 76.85 degrees Celsius.
10.0 degrees Fahrenheit is 260.93 degrees Kelvin.+/
 */

fun main() {
  //Conversiones usando lambdas
    //De grados Celsius a Fahrenheit: °F = 9/5 (°C) + 32
    printFinalTemperature(27.0,"Celsius", "Fahrenheit") {
        celsius ->         9.0 / 5.0 * celsius + 32 //Formula de Celsius a Fahrenheit
    }
    //Kelvin a Celsius: °C = K - 273.15
    printFinalTemperature(350.0,"Kelvin", "Celsius") {
                kelvin -> kelvin - 273.15 //Formula de Kevin a Celsius

        }
     //De Fahrenheit a Kelvin: K = 5/9 (°F - 32) + 273.15
    printFinalTemperature(10.0,"Fahrenheit", "Kelvin") {
             fahrenheit -> 5.0/9.0 * (fahrenheit - 32) + 273.15

        }

}

fun printFinalTemperature(
    initialMeasurement: Double, //La temperatura que vamos a convertir (un valor Double).
    initialUnit: String, //La unidad de la temperatura inicial, como "Celsius", "Fahrenheit" o "Kelvin".
    finalUnit: String, //La unidad a la que queremos convertir la temperatura.
    conversionFormula: (Double) -> Double //Es una lambda que realiza la conversión matemática.
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}