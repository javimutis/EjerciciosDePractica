package com.javimutis.androidmaster.exercises.lambdas

/*Ejercicio: Convertidor de Edad
En este ejercicio, deberás convertir una edad en años a meses, semanas y días usando lambdas.

Las fórmulas son las siguientes:

1 año = 12 meses
1 año = 52 semanas (aproximadamente)
1 año = 365 días (aproximadamente)
Tu tarea es:

Escribir un programa que tome una edad en años y la convierta a meses, semanas y días.
Usar lambdas para las conversiones.
Mostrar el resultado con dos decimales, similar al formato de conversión de temperatura.*/
fun main() {
    // Convertir de años a meses
    printFinalAge(1.0, "Months") { age ->
        age * 12
    }

    // Convertir de años a semanas
    printFinalAge(1.0, "Weeks") { age ->
        age * 52
    }

    // Convertir de años a días
    printFinalAge(1.0, "Days") { age ->
        age * 365
    }
}

fun printFinalAge(
    initialAge: Double,
    conversionUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalAge = String.format("%.2f", conversionFormula(initialAge)) // Dos decimales
    println("$initialAge years is $finalAge $conversionUnit.")
}

