package com.javimutis.androidmaster.superheroapp

import com.google.gson.annotations.SerializedName

/*Explicación clave:
1. Uso de data class
- Se utilizan data class porque son ideales para manejar datos y proporcionan automáticamente métodos útiles (toString(), equals(), hashCode(), etc.).
2. @SerializedName
- Se usa para mapear los nombres de los atributos del JSON a los nombres de las variables en Kotlin.
- Esto es útil cuando los nombres en el JSON tienen espacios, guiones u otros formatos incompatibles con las convenciones de nombres de Kotlin.
3. Estructura de la respuesta de la API:
- SuperheroDetailResponse: Contiene la información detallada de un superhéroe, incluyendo su nombre, estadísticas, imagen y biografía.
- PowerStatsResponse: Representa los atributos de poder del superhéroe, como fuerza, inteligencia, velocidad, etc.
- SuperheroImageDetailResponse: Almacena la URL de la imagen del superhéroe.*/

// Data class que representa la respuesta detallada de un superhéroe cuando se solicita su información específica.
data class SuperheroDetailResponse(
    @SerializedName("name") val name: String, // Nombre del superhéroe.
    @SerializedName("powerstats") val powerstats: PowerStatsResponse, // Estadísticas de poder del superhéroe.
    @SerializedName("image") val image: SuperheroImageDetailResponse, // Imagen del superhéroe.
    @SerializedName("biography") val biography: Biography // Biografía del superhéroe.
)

// Data class que almacena las estadísticas de poder de un superhéroe.
data class PowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String, // Nivel de inteligencia.
    @SerializedName("strength") val strength: String, // Nivel de fuerza.
    @SerializedName("speed") val speed: String, // Nivel de velocidad.
    @SerializedName("durability") val durability: String, // Nivel de durabilidad (resistencia al daño).
    @SerializedName("power") val power: String, // Nivel de poder general.
    @SerializedName("combat") val combat: String // Habilidad en combate.
)

// Data class que almacena la imagen detallada del superhéroe.
data class SuperheroImageDetailResponse(@SerializedName("url") val url: String) // URL de la imagen.
