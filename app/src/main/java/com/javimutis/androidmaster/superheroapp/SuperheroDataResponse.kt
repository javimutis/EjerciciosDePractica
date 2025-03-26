package com.javimutis.androidmaster.superheroapp

import com.google.gson.annotations.SerializedName

/*Explicación clave:
1. Uso de data class
- Se utilizan data class porque son ideales para almacenar datos y generar automáticamente métodos como toString(), equals() y hashCode().
2. @SerializedName
- Se usa esta anotación para mapear los nombres de los campos en JSON a los atributos de las clases en Kotlin.
- Por ejemplo, "full-name" en el JSON se convierte en fullName en Kotlin.
3. Estructura de la respuesta de la API:
- SuperheroDataResponse: Es la respuesta general cuando se busca un superhéroe.
- SuperheroItemResponse: Representa cada superhéroe en la lista de resultados.
- SuperheroImageResponse: Contiene solo la URL de la imagen del superhéroe.
- Biography: Almacena información biográfica del superhéroe.*/

// Data class que representa la respuesta completa de la API al buscar superhéroes.
data class SuperheroDataResponse(
    @SerializedName("response") val response: String, // Indica el estado de la respuesta ("success" o "error").
    @SerializedName("results") val superheroes: List<SuperheroItemResponse> // Lista de superhéroes encontrados.
)

// Data class que representa un superhéroe dentro de la lista de resultados.
data class SuperheroItemResponse(
    @SerializedName("id") val superheroId: String, // ID único del superhéroe.
    @SerializedName("name") val name: String, // Nombre del superhéroe.
    @SerializedName("image") val superheroImage: SuperheroImageResponse // Contiene la URL de la imagen del superhéroe.
)

// Data class que representa la imagen de un superhéroe.
data class SuperheroImageResponse(
    @SerializedName("url") val url: String // URL de la imagen del superhéroe.
)

// Data class que representa la biografía de un superhéroe.
data class Biography(
    @SerializedName("full-name") val fullName: String, // Nombre real del superhéroe.
    @SerializedName("publisher") val publisher: String // Editorial a la que pertenece (Marvel, DC, etc.).
)
