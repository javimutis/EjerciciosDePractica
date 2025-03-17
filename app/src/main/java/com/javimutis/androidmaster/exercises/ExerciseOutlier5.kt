package com.javimutis.androidmaster.exercises

/*Ejercicio 1: Clasificación de Productos en una Tienda
Crea un programa que clasifique productos en una tienda según su precio.
El programa debe imprimir un mensaje basado en el precio del producto de
la siguiente manera:

- Si el precio es menor a $10, imprime "Producto económico".
- Si el precio está entre 10y50, imprime "Producto de precio medio".
- Si el precio está entre 1y100, imprime "Producto caro".
- Si el precio es mayor a $100, imprime "Producto de lujo".
- Si el precio es negativo, imprime "Precio no válido".*/

fun main() {
    val product1Price = 5.0 // Cambia este valor para probar diferentes precios
    val product2Price = 25.0 // Cambia este valor para probar diferentes precios
    val product3Price = 75.0 // Cambia este valor para probar diferentes precios
    val product4Price = 150.0 // Cambia este valor para probar diferentes precios
    val product5Price = -10.0 // Cambia este valor para probar diferentes precios

    println(classifyProductPrice(product1Price))
    println(classifyProductPrice(product2Price))
    println(classifyProductPrice(product3Price))
    println(classifyProductPrice(product4Price))
    println(classifyProductPrice(product5Price))
}

fun classifyProductPrice(price: Double): String {
    return when {
        price < 0 -> "Precio no válido"
        price in 0.0..10.0 -> "Producto económico"
        price in 10.1..50.0 -> "Producto de precio medio"
        price in 51.0..100.0 -> "Producto caro"
        else -> "Producto de lujo"
    }
}