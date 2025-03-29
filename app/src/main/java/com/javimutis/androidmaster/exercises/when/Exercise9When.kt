package com.javimutis.androidmaster.exercises.`when`

/* Explicación del código:
Se crean varias notas en main() para probar el programa.

Se incluyen casos válidos (como 10, 6, 0) y casos inválidos (22, -3).

La función printGrades() evalúa la nota con when.

Usa rangos (in 0..3, in 4..5, etc.) para clasificar las notas.

Si la nota no está dentro del rango esperado, devuelve "Nota inválida".

Se imprime la nota con su respectiva clasificación.

Ejemplo: Nota: 6 -> Bien

Si la nota es incorrecta, se muestra: Nota: 22 -> Nota inválida*/


/**
 * 📌 Clasificación de notas
 *
 * Este programa evalúa una calificación numérica y devuelve una descripción en texto.
 *
 * Rango de notas y su significado:
 *  - 0 a 3   → "Reprobado"
 *  - 4 a 5   → "Suficiente"
 *  - 6 a 7   → "Bien"
 *  - 8 a 9   → "Muy bien"
 *  - 10      → "Excelente"
 *  - Cualquier otro valor → "Nota inválida"
 */

fun main() {
    // 📌 Se definen varias notas para probar la clasificación
    val grade1 = 10  // Excelente
    val grade2 = 22  // Nota inválida
    val grade3 = 0   // Reprobado
    val grade4 = 6   // Bien
    val grade5 = -3  // Nota inválida

    // 📌 Se llama a la función `printGrades()` para evaluar e imprimir cada nota
    printGrades(grade1)
    printGrades(grade2)
    printGrades(grade3)
    printGrades(grade4)
    printGrades(grade5)
}

/**
 * 📌 Función que evalúa la calificación y la clasifica en un texto descriptivo.
 * @param grade Nota numérica que se evaluará.
 */
fun printGrades(grade: Int) {
    // 📌 `when` se usa para asignar una descripción según el rango de la nota
    val gradeDescription = when (grade) {
        in 0..3 -> "Reprobado"       // Notas entre 0 y 3
        in 4..5 -> "Suficiente"      // Notas entre 4 y 5
        in 6..7 -> "Bien"            // Notas entre 6 y 7
        in 8..9 -> "Muy bien"        // Notas entre 8 y 9
        10 -> "Excelente"            // Nota exacta de 10
        else -> "Nota inválida"      // Si la nota está fuera del rango válido
    }

    // 📌 Se imprime la nota junto con su descripción
    println("Nota: $grade -> $gradeDescription")
}
