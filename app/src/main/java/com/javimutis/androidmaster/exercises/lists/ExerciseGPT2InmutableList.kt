package com.javimutis.androidmaster.exercises.lists

/*Días de la semana y actividades recomendadas
En este ejercicio, el usuario ingresa un número del 1 al 7, y el programa debe devolver el
nombre del día y una actividad recomendada.

Reglas:

Lunes a viernes (1-5): "It's a workday. Stay productive!"
Sábado (6): "Weekend! Time to relax or go out."
Domingo (7): "Sunday rest day. Prepare for the new week."
Cualquier otro número: "Invalid day number."

Imprimir:
Wednesday: It's a workday. Stay productive!
Saturday: Weekend! Time to relax or go out.
Sunday: Sunday rest day. Prepare for the new week.
Invalid day number.
*/

fun main() {
    val day1 = 3
    val day2 = 6
    val day3 = 7
    val day4 = 9

    println(getDayInfo(day1))
    println(getDayInfo(day2))
    println(getDayInfo(day3))
    println(getDayInfo(day4))
}

fun getDayInfo(dayNumber: Int): String {
    // Se define una lista inmutable con los nombres de los días de la semana.
    // La posición en la lista (índice) comienza en 0.
    val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    return when (dayNumber) {
        // Si el número está entre 1 y 5, significa que es un día de semana.
        // Se accede al nombre correcto restando 1 a dayNumber, ya que los índices de la lista empiezan en 0.
        in 1..5 -> "${days[dayNumber - 1]}: It's a workday. Stay productive!"

        // Si el número es 6, se accede directamente a days[5] (sábado) para obtener su nombre.
        6 -> "${days[5]}: Weekend! Time to relax or go out."

        // Si el número es 7, se accede directamente a days[6] (domingo) para obtener su nombre.
        7 -> "${days[6]}: Sunday rest day. Prepare for the new week."

        // Para cualquier otro número fuera del rango 1-7, se devuelve un mensaje de error.
        else -> "Invalid day number."
    }
}
/*
//Este resultado es funcional pero es repetitico. Es mejor utilizar listas.
fun getDayInfo(dayNumber: Int): String {
    return when {
        dayNumber == 1 -> "Monday: It's a workday. Stay productive!"
        dayNumber == 2 -> "Tuesday: It's a workday. Stay productive!"
        dayNumber == 3 -> "Wednesday: It's a workday. Stay productive!"
        dayNumber == 4 -> "Thursday: It's a workday. Stay productive!"
        dayNumber == 5 -> "Friday: It's a workday. Stay productive!"
        dayNumber == 6 -> "Saturday: Weekend! Time to relax or go out."
        dayNumber == 7 -> "Sunday: Sunday rest day. Prepare for the new week."
        else -> "Invalid day number."
    }*/


