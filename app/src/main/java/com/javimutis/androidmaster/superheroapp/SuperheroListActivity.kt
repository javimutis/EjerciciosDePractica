package com.javimutis.androidmaster.superheroapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.javimutis.androidmaster.R
import com.javimutis.androidmaster.databinding.ActivitySuperHeroListBinding
import com.javimutis.androidmaster.superheroapp.DetailSuperheroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*Resumen de lo que hace el código:
1. Configura la interfaz de usuario
- Usa ViewBinding para acceder a los elementos de la pantalla.
- Implementa una SearchView para buscar superhéroes por nombre.
- Muestra los resultados en una RecyclerView usando un adaptador personalizado.
2. Realiza una búsqueda de superhéroes en una API
- Usa Retrofit para conectarse a la API.
- Ejecuta la búsqueda en segundo plano con CoroutineScope(Dispatchers.IO).
- Si la respuesta es exitosa, actualiza la lista de superhéroes en la pantalla.
3. Maneja la navegación entre pantallas
- Cuando el usuario selecciona un superhéroe, abre la pantalla de detalles (DetailSuperheroActivity).

Este código es un buen ejemplo de cómo estructurar una actividad en Android usando Retrofit, corrutinas y una RecyclerView.
 */

// Clase que representa la actividad principal donde se muestra la lista de superhéroes.
class SuperheroListActivity : AppCompatActivity() {
    // ViewBinding para acceder a los elementos del layout sin usar findViewById.
    private lateinit var binding: ActivitySuperHeroListBinding

    // Instancia de Retrofit para manejar las peticiones a la API.
    private lateinit var retrofit: Retrofit

    // Adaptador para la RecyclerView que mostrará la lista de superhéroes.
    private lateinit var adapter: SuperheroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Ajusta la interfaz para que los elementos se extiendan hasta los bordes.

        // Inicializa ViewBinding para acceder a las vistas del layout.
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ajusta los márgenes de la vista principal para evitar que la barra de estado y la de navegación cubran la interfaz.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializa Retrofit para realizar peticiones a la API.
        retrofit = getRetrofit()

        // Llama a la función que configura la interfaz de usuario.
        initUI()
    }

    // Configura la interfaz de usuario: búsqueda y RecyclerView.
    private fun initUI() {
        // Agrega un listener a la barra de búsqueda para ejecutar la búsqueda cuando el usuario ingrese texto.
        binding.swSuperhero.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // Se ejecuta cuando el usuario presiona "Enter" en el teclado.
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty()) // Llama a la función de búsqueda con el texto ingresado.
                return false
            }

            // Se ejecuta cada vez que el usuario cambia el texto en la barra de búsqueda (no se usa en este caso).
            override fun onQueryTextChange(newText: String?) = false
        })

        // Inicializa el adaptador de la RecyclerView y define qué hacer cuando se selecciona un ítem.
        adapter = SuperheroAdapter { superheroId -> navigateToDetail(superheroId) }

        // Configura la RecyclerView para mejorar el rendimiento y establecer el diseño en forma de lista.
        binding.rvSuperhero.setHasFixedSize(true) // Optimiza la lista si los elementos tienen un tamaño fijo.
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this) // Usa un diseño de lista vertical.
        binding.rvSuperhero.adapter = adapter // Asigna el adaptador a la RecyclerView.
    }

    // Función que busca superhéroes por nombre en la API.
    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true // Muestra el indicador de carga mientras se obtiene la respuesta.

        // Lanza una corrutina en el hilo de fondo (IO) para no bloquear la interfaz de usuario.
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperheroDataResponse> =
                retrofit.create(ApiService::class.java).getSuperheroes(query) // Realiza la llamada a la API.

            if (myResponse.isSuccessful) { // Verifica si la respuesta fue exitosa.
                Log.i("mutisapp", "Funciona") // Mensaje en consola para depuración.

                val response: SuperheroDataResponse? = myResponse.body() // Obtiene el cuerpo de la respuesta.
                if (response != null) {
                    Log.i("mutisapp", response.toString()) // Imprime la respuesta en la consola.

                    // Actualiza la lista en la interfaz de usuario desde el hilo principal.
                    runOnUiThread {
                        adapter.updateList(response.superheroes) // Actualiza la lista de la RecyclerView.
                        binding.progressBar.isVisible = false // Oculta el indicador de carga.
                    }
                }
            } else {
                Log.i("mutisapp", "No funciona") // Mensaje en consola si la API falla.
            }
        }
    }

    // Función que configura Retrofit para hacer peticiones a la API.
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/") // URL base de la API.
            .addConverterFactory(GsonConverterFactory.create()) // Convierte automáticamente la respuesta JSON en objetos de Kotlin.
            .build()
    }

    // Función que abre la pantalla de detalles de un superhéroe cuando se selecciona uno de la lista.
    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailSuperheroActivity::class.java) // Crea un intent para abrir la nueva actividad.
        intent.putExtra(EXTRA_ID, id) // Agrega el ID del superhéroe seleccionado como extra.
        startActivity(intent) // Inicia la nueva actividad.
    }
}
