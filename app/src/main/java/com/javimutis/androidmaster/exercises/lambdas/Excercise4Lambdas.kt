package com.javimutis.androidmaster.exercises.lambdas

/*Filtrar y Procesar Lista de Productos
Imagina que tienes una tienda en línea y deseas procesar una lista de productos con precios.
Debes realizar las siguientes tareas utilizando lambdas:

Requisitos:

Filtrar los productos cuyo precio es mayor a un valor dado (puedes usar un precio arbitrario para el filtro).
A continuación, aplicar un descuento del 10% a esos productos.
Mostrar la lista de productos con su nombre y precio después del descuento, pero solo los que pasaron el filtro.
Sugerencias:

Usa una lista de objetos de tipo Producto que tenga un nombre (String) y un precio (Double).
Utiliza filter para filtrar los productos por precio.
Usa map para aplicar el descuento a los productos filtrados.
Utiliza String.format("%.2f", valor) para mostrar los precios con dos decimales.
*/

fun main() {
    val productos = listOf(
        Producto("Laptop", 3500.0),
        Producto("SmartPhone", 800.0),
        Producto("Lavadora", 1000.0),
        Producto("Cámara", 3000.0)
    )

    // Filtra los productos con precio mayor a 1000 y aplica un descuento del 10%
    val productosConDescuento = productos
        .filter { it.precioOriginal > 1000 } // Filtra productos con precio mayor a 1000
        .map {
            // Aplica un descuento del 10% a cada producto filtrado
            it.copy(precioOriginal = it.precioOriginal * 0.9)
        }

    // Imprime los productos con el precio después del descuento
    productosConDescuento.forEach { producto ->
        println("Producto: ${producto.nombre}, Precio después del descuento: ${String.format("%.2f", producto.precioOriginal)}")
    }
}

// Data class para representar un producto
data class Producto(val nombre: String, val precioOriginal: Double)
