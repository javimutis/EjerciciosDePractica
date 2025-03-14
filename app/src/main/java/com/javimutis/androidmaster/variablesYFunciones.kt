package com.javimutis.androidmaster

//VARIABLES. Se escriben en camelCase. primera letra minuscula siguiente palabra en Mayuscula

/**
 * Variables de alfanuméricas
 */
//val no se puede modificar. En este caso String que es para textos.
val stringExample1 = "Javiera Mutis"
//String Son valores de textos y puede soportar lo que sea, si no se donde poner pongo String
val stringExample2 = "Tegula 270"
//Var es modificable.
var varExample = 35
/**
 * Concatenación de variables
 */
var concatExample = stringExample1 + " " + stringExample2
//Variable concatenada
val exampleConcat: String = varExample.toString()
var stringConcatExample = "Hola, me llamo $stringExample1 y tengo $exampleConcat años"


fun main() {
    //Me llamo Javiera Mutis
    showMyName()
    //Tengo 35 años
    showMyAge()
    //8
    add(3,5)
    //5
    val mySubtract= subtract(10, 5)
    println (mySubtract)
    //15
    val mySubtractCool= subtractCool(20, 5)
    println (mySubtractCool)
}
//Funciones con parametros vacios
fun showMyName() {
    println("Me llamo Javiera Mutis")
}
//Funciones con pParametros de entrada: la entrada te la da el usuario. No es fijo
fun showMyAge(currentAge:Int = 35) {
    println("Tengo $currentAge años")
}

fun add(firstNumber:Int, secondNumber:Int){
    println(firstNumber + secondNumber)
}
//Funciones con parametro de salida
fun subtract(firstNumber:Int, secondNumber:Int): Int {
   return firstNumber - secondNumber
}
//Simplificación de función
fun subtractCool(firstNumber:Int, secondNumber:Int) = firstNumber - secondNumber


    fun variablesAlfaNumericas() {
        //Char Son valores de un solo caracter, puede ser numero o letra o lo que quieras
        var charExample1: Char = 'F'
        var charExample2: Char = '5'
        var charExample3: Char = '+'
        println(stringConcatExample)

        /**
         * Concatenación de variables con operadores
         */
        var concatExample2 = "$stringExample1 $stringExample2"

        /**
         * Concatenación con salto de espacio
         */
        var concatExample3 = "$stringExample1 \n$stringExample2"

        /**
         * Pintar resultados
         */
        //Javiera Mutis Tegula 270
        println(concatExample)

        //Javiera Mutis Tegula 270
        println(concatExample2)

        //Javiera Mutis
        //Tegula 270
        println(concatExample3)

        //Hola, me llamo Javiera Mutis y tengo 35 años
        println(stringConcatExample)
    }

    fun variablesBoolean() {
        /**
         * Variables booleanas
         */
        //Boolean Son valores true o false
        var booleanExample1 = false //Boolean
        val booleanExample2 = true  //Boolean


    }

    fun variablesNumericas() {

        /**
         * Variables numéricas
         */

        //Int Son valores enteros. Desde -2.147.483.647 hasta 2.147.483.647
        var intExample: Int = 2430386
        //Long Son valores enteros. Desde -9.223.372.036.854.775.808 hasta 9.223.372.036.854.775.807.
        // No es tan recomentable porque ocupa mucho espacio en la mememoria.
        var longExample: Long = 2430386545454545151
        //Float Son valores decimales. Desde 1.4E-45 hasta 3.4028235E38. En float se debe poner f al final
        var floatExample: Float = 80.5f
        //Double Son valores decimales. Desde 4.9E-324 hasta 1.7976931348623157E308 . También usa mas memoria
        var doubleExample: Double = 1.80


        //Sumar:
        //2430421
        println("Sumar:")
        println(varExample + intExample)

        //Sumar: 35 + 2430386 = 2430421
        println("Sumar: $varExample + $intExample = ${varExample + intExample}")

        //Multiplicar
        //3.6
        println("Multiplicar")
        println(doubleExample * 2)

        //Dividir: 35 / 2430386
        println("Dividir: $varExample / $intExample")

        //Dividir:
        //0
        println("Dividir:")
        println(varExample / intExample)

        //Dividir: 35 / 2430386 = 0
        println("Dividir: $varExample / $intExample = ${varExample / intExample}")

        //Porcentaje de
        //35 % 2430386
        println("Porcentaje de")
        println("$varExample % $intExample")


    }
