package com.javimutis.androidmaster.sintaxis

fun main() {
    // Llama a la función getSemester con el valor 2 y imprime el resultado
    println(getSemester(2))
}

// Función que imprime un resultado basado en el tipo de valor
fun result(value: Any) {
    when (value) {
        is Int -> println(value + value + 5) // Si es un Int, imprime el doble del valor más 5
        is String -> println(value) // Si es un String, imprime el valor
        is Boolean -> if (value) println("Es verdadero") else println("Es falso") // Si es Boolean, imprime si es verdadero o falso
    }
}

// Función que imprime el nombre del mes basado en el número
fun getMonth(month: Int) {
    when (month) {
        1 -> println("Enero")
        2 -> println("Febrero")
        3 -> println("Marzo")
        4 -> println("Abril")
        5 -> println("Mayo")
        6 -> println("Junio")
        7 -> println("Julio")
        8 -> println("Agosto")
        9 -> println("Septiembre")
        10 -> println("Octubre")
        11 -> println("Noviembre")
        12 -> println("Diciembre")
        else -> println("No es un mes") // Si el número no es de 1 a 12, imprime que no es un mes
    }
}

// Función que imprime el trimestre basado en el número del mes
fun getTrimester(month: Int) {
    when (month) {
        1, 2, 3 -> println("Primer trimestre") // Meses 1 a 3
        4, 5, 6 -> println("Segundo trimestre") // Meses 4 a 6
        7, 8, 9 -> println("Tercer trimestre") // Meses 7 a 9
        10, 11, 12 -> println("Cuarto trimestre") // Meses 10 a 12
        else -> println("No es un trimestre") // Si el número no es de 1 a 12, imprime que no es un trimestre
    }
}

// Función que devuelve el semestre basado en el número del mes
fun getSemester(month: Int) = when(month) {
    in 1..6 -> "Primer semestre" // Meses 1 a 6
    in 7..12 -> "Segundo semestre" // Meses 7 a 12
    !in 1..12 -> "No es un mes correcto" // Si el número no está entre 1 y 12, indica que no es un mes correcto
    else -> "No es un mes" // Caso por defecto, aunque no se alcanzará debido a las condiciones anteriores
}