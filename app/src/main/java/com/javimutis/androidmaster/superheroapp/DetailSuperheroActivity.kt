package com.javimutis.androidmaster.superheroapp

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.javimutis.androidmaster.R
import com.javimutis.androidmaster.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

/*Explicación clave:
1. Uso de companion object:
- Permite definir constantes accesibles en toda la clase sin necesidad de instanciarla.
2. Corrutinas con CoroutineScope(Dispatchers.IO).launch {}:
- Ejecuta la llamada a la API en un hilo secundario para no bloquear la interfaz.
3. Uso de runOnUiThread {}:
- Permite actualizar la UI solo en el hilo principal.
4. Uso de Picasso.get().load(url).into(imageView):
- Carga imágenes desde una URL y las muestra en un ImageView.
5. Conversión de valores con pxToDp():
- Asegura que los tamaños de las barras de estadísticas se ajusten correctamente en diferentes dispositivos.*/

// Esta clase representa la pantalla de detalles de un superhéroe.
class DetailSuperheroActivity : AppCompatActivity() {

    // Companion object:Se usa para definir constantes o métodos estáticos que pueden ser usados en toda la clase.
    companion object {
        const val EXTRA_ID = "extra_id" // Clave para recibir el ID del superhéroe desde otra pantalla.
    }

    // Variable para manejar el binding (enlace entre XML y código).
    private lateinit var binding: ActivityDetailSuperheroBinding

    // Método que se ejecuta cuando la actividad se crea.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Activa el diseño en pantalla completa en algunos dispositivos.
        enableEdgeToEdge()

        // Inicializa el binding para conectar con el XML de la interfaz.
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)

        // Define el diseño de la actividad usando el binding.
        setContentView(binding.root)
        // Ajusta los márgenes de la pantalla para adaptarse a las barras del sistema.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtiene el ID del superhéroe desde el intent que inició la actividad.
        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()

        // Llama a la función para obtener la información del superhéroe.
        getSuperheroInformation(id)
    }

    // Función que obtiene la información del superhéroe desde la API.
    private fun getSuperheroInformation(id: String) {
        // Se usa una corrutina en el hilo secundario (IO) para no bloquear la interfaz de usuario.
        CoroutineScope(Dispatchers.IO).launch {
            // Llamada a la API para obtener los detalles del superhéroe.
            val superheroDetail =
                getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)

            // Si la respuesta de la API no es nula, se actualiza la interfaz en el hilo principal.
            if (superheroDetail.body() != null) {
                runOnUiThread {
                    createUI(superheroDetail.body()!!) // Crea la interfaz con la info obtenida.
                }
            }
        }
    }

    // Función que actualiza la interfaz de usuario con los datos del superhéroe.
    private fun createUI(superhero: SuperheroDetailResponse) {
        // Carga la imagen del superhéroe usando la librería Picasso.
        Picasso.get().load(superhero.image.url).into(binding.ivSuperhero)

        // Muestra el nombre del superhéroe en el TextView correspondiente.
        binding.tvSuperheroName.text = superhero.name

        // Prepara las estadísticas del superhéroe (fuerza, velocidad, etc.).
        prepareStats(superhero.powerstats)

        // Muestra el nombre real del superhéroe.
        binding.tvSuperheroRealName.text = superhero.biography.fullName

        // Muestra la editorial del superhéroe (Marvel, DC, etc.).
        binding.tvPublisher.text = superhero.biography.publisher
    }

    // Función que configura las estadísticas del superhéroe.
    private fun prepareStats(powerstats: PowerStatsResponse) {
        updateHeight(binding.viewCombat, powerstats.combat) // Actualiza la barra de combate.
        updateHeight(binding.viewDurability, powerstats.durability) // Durabilidad.
        updateHeight(binding.viewSpeed, powerstats.speed) // Velocidad.
        updateHeight(binding.viewStrength, powerstats.strength) // Fuerza.
        updateHeight(binding.viewIntelligence, powerstats.intelligence) // Inteligencia.
        updateHeight(binding.viewPower, powerstats.power) // Poder.
    }

    // Función que ajusta la altura de una vista (barra de estadísticas).
    private fun updateHeight(view: View, stat: String) {
        val params = view.layoutParams // Obtiene los parámetros de la vista.
        params.height = pxToDp(stat.toFloat()) // Convierte el valor a dp y lo asigna como altura.
        view.layoutParams = params // Aplica los nuevos parámetros a la vista.
    }

    // Función que convierte valores de píxeles (px) a densidad independiente de píxeles (dp).
    private fun pxToDp(px: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics)
            .roundToInt()
    }

    // Función que configura y devuelve un objeto Retrofit para hacer llamadas a la API.
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/") // URL base de la API.
            .addConverterFactory(GsonConverterFactory.create()) // Convierte JSON a objetos Kotlin.
            .build()
    }
}