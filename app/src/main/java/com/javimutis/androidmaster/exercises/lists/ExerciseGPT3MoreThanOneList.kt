package com.javimutis.androidmaster.exercises.lists

/*
Gestión de inventario de una tienda
En este ejercicio, gestionaremos el stock de una tienda usando una lista.

Si el producto está en stock, el programa debe imprimir: "The product [nombre] is available."
Si el producto no está en stock, el programa debe imprimir: "The product [nombre] is out of stock."

Ejemplo de salida esperada:
The product Mouse is available.
The product Jeans is available.
The product Tablet is out of stock.
*/
fun main() {
    val electronicsStock = listOf("Laptop", "Mouse", "Keyboard", "Monitor", "USB Drive")
    val clothingStock = listOf("Shirt", "Jeans", "Jacket", "Hat")

    val product1 = "Mouse"
    val product2 = "Jeans"
    val product3 = "Tablet"


    showStockMessage(product1, electronicsStock, "Electronics")  // Aquí paso "Electronics"
    showStockMessage(product2, clothingStock, "Clothing")       // Aquí paso "Clothing"
    showStockMessage(product3, electronicsStock, "Electronics") // Aquí paso "Electronics" otra vez
}

// Recibe el nombre del producto, la lista de stock y la categoría, la categoria no es una variable global, se pasa de forma directa
fun showStockMessage(product: String, stock: List<String>, category: String) {
    val message = checkStock(product, stock)
    println("[$category] $message")  // Aquí usa category
}

//product: String → es el nombre del producto que queremos verificar.
//stock: List<String> → es una lista de productos disponibles (que pasamos desde main()).
//product in stock → Verifica si el producto existe dentro de la lista stock.
//stock contiene los mismos elementos que availableProducts, porque availableProducts se pasó
// como argumento.
fun checkStock(product: String, stock: List<String>): String {
    println("Checking stock for: $product in $stock") // Muestra qué lista se está usando
    return if (product in stock) {
        "The product $product is available."
    } else {
        "The product $product is out of stock."
    }
}
