package com.javimutis.androidmaster.exercises.`when`


/*Explicación del código:
Se crean tres valores en main() para probar la función.

1 (lunes), 7 (domingo) y 9 (número inválido).

Se usa when en daysOfTheWeek() para asignar el nombre del día.

Compara day con valores del 1 al 7 y devuelve el nombre correspondiente.

Si el número no está en el rango, muestra "Número inválido".

Se imprime el resultado.

Ejemplo:

kotlin
Copiar
Editar
daysOfTheWeek(1)  // lunes
daysOfTheWeek(7)  // domingo
daysOfTheWeek(9)  // Número inválido*/


/**
 * 📌 Días de la semana
 *
 * Este programa recibe un número del 1 al 7 y devuelve el nombre del día correspondiente.
 * Si el número no está en el rango válido, muestra "Número inválido".
 *
 * Ejemplos:
 *  - 1 → "lunes"
 *  - 5 → "viernes"
 *  - 7 → "domingo"
 *  - 9 → "Número inválido" (porque no está en el rango de 1 a 7)
 */

fun main() {
    // 📌 Se definen tres valores para probar el programa.
    val monday = 1     // Representa el lunes
    val sunday = 7     // Representa el domingo
    val invalid = 9    // Valor fuera del rango válido

    // 📌 Se llama a la función `daysOfTheWeek()` para determinar el día correspondiente
    daysOfTheWeek(monday)  // Debería imprimir "lunes"
    daysOfTheWeek(sunday)  // Debería imprimir "domingo"
    daysOfTheWeek(invalid) // Debería imprimir "Número inválido"
}

/**
 * 📌 Función que recibe un número y devuelve el día de la semana correspondiente.
 * @param day Número del 1 al 7 que representa un día de la semana.
 */
fun daysOfTheWeek(day: Int) {
    // 📌 Se usa `when` para comparar el valor de `day` con cada posible día de la semana.
    val dayName = when (day) {
        1 -> "lunes"      // Si `day` es 1, el día es "lunes"
        2 -> "martes"     // Si `day` es 2, el día es "martes"
        3 -> "miércoles"  // Si `day` es 3, el día es "miércoles"
        4 -> "jueves"     // Si `day` es 4, el día es "jueves"
        5 -> "viernes"    // Si `day` es 5, el día es "viernes"
        6 -> "sábado"     // Si `day` es 6, el día es "sábado"
        7 -> "domingo"    // Si `day` es 7, el día es "domingo"
        else -> "Número inválido" // Si el número no está entre 1 y 7, devuelve un error
    }

    // 📌 Se imprime el nombre del día correspondiente
    println(dayName)
}
