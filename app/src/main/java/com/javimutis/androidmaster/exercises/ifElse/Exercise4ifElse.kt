package com.javimutis.androidmaster.exercises.ifElse

/*Calculadora de descuentos (Desafío para principiantes)
Crea un programa que pida el precio original de un producto y el porcentaje de descuento.
El programa debe calcular el precio final después del descuento.
Reglas:

Si el descuento es 0% o menor, el precio final es el mismo.

Si el descuento es mayor al 100%, muestra un mensaje de error.*/

fun main() {

    val originalPrice1 = 1000
    val originalPrice2 = 500
    val originalPrice3 = 200

    val discount1 = 20
    val discount2 = 0
    val discount3 = 120

    printDiscount(originalPrice1, discount1)
    printDiscount(originalPrice2, discount2)
    printDiscount(originalPrice3, discount3)

}

fun printDiscount(originalPrice: Int, discount: Int) {
    println("Ingrese el precio original: $originalPrice")
    println("Ingrese el descuento (%): $discount.")

    val discountAmount = originalPrice * (discount / 100.0)
    val finalPrice = originalPrice - discountAmount

    if (discount >= 1 && discount <= 100) {
        println("El precio final con descuento es: $finalPrice")
    } else if (discount <= 0) {
        println("El precio final con descuento es: $originalPrice")
    } else{ (discount >= 101)
    println("Error: El descuento no puede ser mayor al 100%.")
}
}