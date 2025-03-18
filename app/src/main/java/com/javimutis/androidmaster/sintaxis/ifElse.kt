package com.javimutis.androidmaster.sintaxis

fun main() {
    ifMultipleOr()
}

// if Multiple utilizando || permite evaluar varias condiciones y que sea una o la otra
fun ifMultipleOr() {
    var pet = "dog"
    var isHappy = true

    if (pet == "dog" || (pet == "cat" && isHappy)) {
        println("Es un perro o gato")
    }else{
        println("No es un perro o es un gato triste")
    }
}
//if multiple permite evaluar condiciones, si se usa && son todas las condiciones deben ser verdaderas
fun ifMultiple() {
    var age = 18
    var parentPermission = false
    var isHappy = true

    if (age >= 18 && parentPermission && isHappy) {
        println("Puedes beber cerveza")
    }else{
        println("No puedes beber cerveza")
    }
}
//Un if Int permite evaluar valores numéricos y utilizar el mayor, menor o igual
fun ifInt() {
    var age = 18
    if (age >= 18) {
        println("Eres mayor de edad")
    }else{
        println("Eres menor de edad")
    }
}

//Un if Boolean es un if que permite evaluar una sola condicion como true o false
fun ifBoolean() {
    var soyFeliz:Boolean = true
    //Sin nada es true
    //Con ! es false
    if(!soyFeliz){
        println("Estoy triste")
    }else{
        println("Estoy feliz")
    }
    }


// Un if anidado es un if dentro de un if que permite evaluar varias condiciones
fun ifAnidado() {
    val animal = "Canguro"

    if (animal == "dog") {
        println("Es un perro")
    } else if (animal == "cat") {
        println("Es un gato")
    } else if (animal == "fish") {
        println("Es un pez")
    } else {
        println("No es ninguno de los animales esperados")
    }


// Un if basico es un if que permite evaluar una sola condicion
    fun ifBasic() {
        val name = "Mutis"
        //Debe estar escrito exactamente igual
        if (name == "Javi") {
            println("Mi nombre es $name")
        } else {
            println("Mi nombre no es $name")
        }
    }
}