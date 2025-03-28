package com.javimutis.androidmaster.exercises.classes

/*Gestión de Vehículos
Imagina que estás desarrollando una aplicación para gestionar información sobre vehículos.

Instrucciones
Crea una clase Car que incluya los siguientes elementos:
1. Propiedades:
- brand: Marca del auto (String)
- model: Modelo del auto (String)
- year: Año de fabricación (Int)
- mileage: Kilometraje actual (Int)
2. Método:
- drive(km: Int): Aumenta el kilometraje del auto según la cantidad de kilómetros recorridos.
3. Imprimir: [Marca] [Modelo] - Año: [Año], Kilometraje: [Kilometraje] km
*/

fun main(){

    val ignis = Car("Suzuki", "Ignis", 2005, 20000 )
    val a3 = Car("Audi", "A 3", 2025, 0)

    ignis.drive(90000)
    a3.drive(0)

    ignis.printDescription()
    a3.printDescription()
}

class Car (val brand: String, val model: String, val year: Int, var mileage: Int){

    fun drive(km:Int){
        if(km > 0) {
            mileage += km
        }else{
            println("La distancia recorrida debe ser positiva")
        }
    }
    fun printDescription() {
        println("$brand, $model - Año: $year, Kilometraje: $mileage km")
    }



}