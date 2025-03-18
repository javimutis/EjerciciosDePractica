package com.javimutis.androidmaster.sintaxis

fun main() {
    mutableList()
}

//Las listas mutables, se pueden modificar
fun mutableList() {
    var weekDays: MutableList<String> =
        mutableListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    println(weekDays)
    //Al poner el numero de indice, indico en que lugar de la lista quiero que se agregue el nuevo elemento
    weekDays.add(0, "JaviDay")
    println(weekDays)

    if (weekDays.isEmpty()) {
        println("La lista esta vacia")
    } else {
        weekDays.forEach({ println(it) })
    }

    weekDays.last()


}

// es una lista inmutable, no se puede modificar. Tiene un tamaño fijo
fun inmutableList() {
    val readOnly: List<String> =
        listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    //7
    println(readOnly.size)
    //[Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo]
    println(readOnly) // es lo mismo que poner println(readOnly.toString())
    //Martes
    println(readOnly[1])
    //Domingo
    println(readOnly.last())
    //Lunes
    println(readOnly.first())

    // Va a filtrar y mostrar solo los resultados que tengan la letra a
    val example = readOnly.filter { it.contains("a") }
    println(example)

    // forEach es un bucle para recorrer la lista y mostrar los elementos que contiene la lista
    //Impreso se vería así:
    // Lunes
    //Martes
    //Miercoles
    //Jueves
    //Viernes
    //Sabado
    //Domingo
    readOnly.forEach { weekDay -> println(weekDay) }

}