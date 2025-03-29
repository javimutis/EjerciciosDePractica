package com.javimutis.androidmaster.exercises.`when`

/*Calcular el impuesto sobre la renta
Crea un programa que calcule el impuesto sobre la renta basado en el ingreso anual:

- 10% para ingresos de hasta $30,000.
- 20% para ingresos entre $30,001 y $70,000.
- 30% para ingresos superiores a $70,000.
- Un valor de -1 para indicar que el ingreso no es válido.*/

fun main() {
    val income1 = 25000
    val income2 = 50000
    val income3 = 80000
    val invalidIncome = -5000

    println("The tax for an income of \$${income1} is \$${incomeTax(income1)}.")
    println("The tax for an income of \$${income2} is \$${incomeTax(income2)}.")
    println("The tax for an income of \$${income3} is \$${incomeTax(income3)}.")
    println("The tax for an income of \$${invalidIncome} is \$${incomeTax(invalidIncome)}.")
}

fun incomeTax(income: Int): Double {
  return when{
      income in 0.. 30000 -> income * 0.10 // 10% de impuesto
      income in 30001..70000 -> income * 0.20 // 20% de impuesto
      income > 70000 -> income * 0.30 // 30% de impuesto
      else -> -1.0 // Para cualquier otro caso no esperado
  }
}