package com.javimutis.androidmaster.exercises.`when`

/**
 * Días de la semana (Fácil)
Crea un programa que reciba un número del 1 al 7 y devuelva el día
de la semana correspondiente.
Por ejemplo:

1 → "Lunes"
7 → "Domingo"
Si el número no está en el rango válido, imprime "Número inválido".
 */
fun main() {
    val monday = 1
    val sunday = 7
    val invalid = 9

    daysOfTheWeek(monday)
    daysOfTheWeek(sunday)
    daysOfTheWeek(invalid)
}

fun daysOfTheWeek(day: Int) {

    val dayName = when (day) {
        1 -> "lunes"
        2 -> "martes"
        3 -> "miércoles"
        4 -> "jueves"
        5 -> "viernes"
        6 -> "sabado"
        7 -> "domingo"
        else ->
            "Número inválido"
    }
    println(dayName)
}