package com.javimutis.androidmaster.exercises

/*Descuentos en una tienda
Crea un programa que calcule el precio final de un producto después
de aplicar un descuento basado en el tipo de cliente:

- Cliente regular: 0% de descuento.
- Cliente VIP: 20% de descuento.
- Cliente nuevo: 10% de descuento.
- Un valor de -1 para indicar que el tipo de cliente no es válido.
Completa la función finalPrice() para que el programa imprima el
precio final después del descuento.*/

fun main() {
    val regularPrice = 100.0
    val vipPrice = 100.0
    val newCustomerPrice = 100.0
    val invalidPrice = 100.0

    println("The final price for a regular customer is \$${finalPrice(regularPrice, "regular")}.")
    println("The final price for a VIP customer is \$${finalPrice(vipPrice, "VIP")}.")
    println("The final price for a new customer is \$${finalPrice(newCustomerPrice, "new")}.")
    println(
        "The final price for an invalid customer type is \$${
            finalPrice(
                invalidPrice,
                "unknown"
            )
        }."
    )
}

// Función que calcula el precio final basado en el tipo de cliente.
fun finalPrice(originalPrice: Double, customerType: String): Double {
    // Usamos una expresión 'when' para determinar el precio final según el tipo de cliente.
    return when (customerType) {
        "regular" -> originalPrice // Para clientes regulares, no hay descuento.
        "VIP" -> originalPrice * 0.8 // Para clientes VIP, se aplica un 20% de descuento.
        "new" -> originalPrice * 0.9 // Para nuevos clientes, se aplica un 10% de descuento.
        else -> -1.0 // Si el tipo de cliente no es válido, devolvemos -1.0.
    }
}