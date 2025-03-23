package com.javimutis.androidmaster.exercises.lambdas

/* Calculadora de Promedio Ponderado
Imagina que eres un profesor y necesitas calcular el promedio ponderado de las calificaciones de tus estudiantes. Cada estudiante tiene varias calificaciones y un peso asignado a cada una. Debes escribir una función que calcule el promedio ponderado de un estudiante usando lambdas.

Requisitos:
- Notas y pesos: Crea una lista de pares de Double, donde cada par consiste de una
calificación (nota) y su respectivo peso (por ejemplo, un examen tiene un peso
mayor que una tarea).
 - Lambda para cálculo ponderado: Usa una lambda para calcular el promedio ponderado,
  la cual tomará la lista de notas y pesos como entrada y devolverá el promedio ponderado.
 - Mostrar resultado: Utiliza una función para mostrar el resultado con dos decimales.
Sugerencia:
Usa String.format("%.2f", /* cálculo */) para mostrar el resultado con dos decimales.
Puedes usar un reduce o un map combinado con un zip para combinar las listas de notas y pesos.
*/

fun main() {
    // Rellena las listas de notas y pesos
    val notas = listOf(90.0, 80.0, 85.0, 95.0) // Notas del estudiante
    val pesos = listOf(0.3, 0.2, 0.2, 0.3) // Pesos de las asignaturas

    // Llama a la función que calcula el promedio ponderado
    // Usa una lambda para el cálculo
    calcularPromedioPonderado(notas, pesos) { notasYPesos ->
        val sumaNotasPonderadas = notasYPesos.sumOf{ (nota, peso) -> nota * peso } //Suma el producto de cada nota por su peso, que es la suma de las notas ponderadas.
        val sumaPesos = notasYPesos.sumOf {it.second} //Suma los pesos, que están en la segunda posición del par (nota, peso) (por eso usamos it.second).
        sumaNotasPonderadas / sumaPesos
        }
}

fun calcularPromedioPonderado(
    notas: List<Double>,
    pesos: List<Double>,
    calculo: (List<Pair<Double, Double>>) -> Double
) {
    // Pairs de notas y pesos
    val notasYPesos = notas.zip(pesos)  // Combina las listas de notas y pesos en una lista de pares (nota, peso).

    // Usa la lambda pasada para calcular el promedio ponderado
    val promedio = calculo(notasYPesos)

    // Muestra el resultado con dos decimales
    println("El promedio ponderado es: ${String.format("%.2f", promedio)}")
}

