package com.javimutis.androidmaster.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/*Explicación clave:
1. Interfaz ApiService:
- Define las funciones que permiten conectarse a la API.
- Usa Retrofit para manejar solicitudes HTTP de manera sencilla.
2. @GET:
- Indica que la función hará una solicitud GET a la API.
3. suspend:
- Hace que la función sea suspendida, lo que significa que se ejecutará de forma asíncrona.
- Se usa con corutinas para no bloquear el hilo principal.
4. @Path("{variable}"):
- Indica que esa parte de la URL será reemplazada por un valor dinámico.
5. Response<T>:
-Envuelve la respuesta del servidor dentro de un objeto Response que contiene los datos solicitados.*/

// Definimos una interfaz llamada ApiService.
// Esta interfaz se usa para hacer solicitudes HTTP a una API de superhéroes.
interface ApiService {

    // Primera función: getSuperheroes
    // -------------------------------------------------------------------------
    // Realiza una solicitud GET a la API para buscar superhéroes por su nombre.
    // La URL tendrá la forma: "/api/{API_KEY}/search/{name}"
    // La variable 'superheroName' será reemplazada dinámicamente en la URL.
    // La función devuelve un objeto Response que contiene SuperheroDataResponse.
    @GET("/api/e4a3cf1f1756ed7a0424ebb3fb24cd8c/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperheroDataResponse>

    // Segunda función: getSuperheroDetail
    // -------------------------------------------------------------------------
    // Realiza una solicitud GET a la API para obtener los detalles de un superhéroe.
    // La URL tendrá la forma: "/api/{API_KEY}/{id}"
    // La variable 'superheroId' será reemplazada dinámicamente en la URL.
    // La función devuelve un objeto Response que contiene SuperheroDetailResponse.
    @GET("/api/e4a3cf1f1756ed7a0424ebb3fb24cd8c/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId: String): Response<SuperheroDetailResponse>
}