package com.javimutis.androidmaster.settings

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.javimutis.androidmaster.R
import com.javimutis.androidmaster.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
/*Conceptos clave que se aplican en este código:
1. Jetpack DataStore 📁
-Se usa para guardar configuraciones de usuario en lugar de SharedPreferences.
2. Corrutinas (Kotlin Coroutines) 🚀
- Se utilizan launch y Dispatchers.IO para ejecutar tareas en segundo plano sin bloquear la UI.
3. Flow 🔄
- Se usa Flow<SettingsModel> para recibir actualizaciones en tiempo real de las configuraciones guardadas.
4. ViewBinding 🖼️
- Se usa ActivitySettingsBinding para acceder a las vistas de la interfaz de manera más segura y eficiente.
5. Modo oscuro con AppCompatDelegate 🌗
- Se permite alternar entre modo oscuro y claro dinámicamente.*/

//Persistencia de datos. Guardar información. Preferencias en este caso. Se puede usar room para guardar en la base de datos
// SQLlite para guardar en la base de datos y en este caso se va a usar DataStore para guardar en la base de datos.
// Lo ideal es que esté en un fichero distinto pero para empezar está bien que esté aquí

//flow: canal para estar escuchando continuamente un valor. avisa de cambios de forma continua, siempre se tiene la ultima información

// Se define un DataStore de preferencias en el contexto de la aplicación para almacenar configuraciones de usuario.
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

// Clase que representa la pantalla de configuración de la aplicación.
class SettingsActivity : AppCompatActivity() {

    // Objeto companion que almacena las claves para las preferencias guardadas.
    companion object {
        const val VOLUME_LVL = "volume_lvl" // Clave para guardar el nivel de volumen
        const val KEY_BLUETOOTH = "key_bluetooth" // Clave para la configuración de Bluetooth
        const val KEY_VIBRATION = "key_vibration" // Clave para la configuración de vibración
        const val KEY_DARK_MODE = "key_dark_mode" // Clave para la configuración del modo oscuro
    }

    // Variable para manejar la vista con ViewBinding
    private lateinit var binding: ActivitySettingsBinding
    // Variable para controlar si es la primera vez que se carga la actividad
    private var firstTime: Boolean = true

    // Método que se ejecuta cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Habilita un diseño de pantalla extendida (si es compatible)
        binding = ActivitySettingsBinding.inflate(layoutInflater) // Inicializa el ViewBinding
        setContentView(binding.root) // Establece la vista de la actividad

        // Ajusta la interfaz para que tenga en cuenta los márgenes del sistema (barra de estado, navegación, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Se ejecuta una corrutina en el ciclo de vida de la actividad para recuperar las configuraciones guardadas
        lifecycleScope.launch {
            getSettings().collectLatest { settingsModel ->
                // Se actualizan los valores de los controles de la interfaz con los datos guardados
                binding.switchVibration.isChecked = settingsModel.vibration
                binding.switchDarkMode.isChecked = settingsModel.darkMode
                binding.switchBluetooth.isChecked = settingsModel.bluetooth
                binding.rsVolume.setValues(settingsModel.volume.toFloat())
            }
        }

        // Inicializa los eventos de la interfaz
        initUI()
    }

    // Método que configura los eventos de los controles en la pantalla de configuración
    private fun initUI() {
        // Detecta cambios en el slider de volumen y guarda el nuevo valor
        binding.rsVolume.addOnChangeListener { _, value, _ ->
            Log.i("mutisApp", "Volumen $value") // Muestra el valor en la consola
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt()) // Guarda el volumen en el DataStore
            }
        }

        // Detecta cambios en el switch de Bluetooth y guarda la configuración
        binding.switchBluetooth.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_BLUETOOTH, value)
            }
        }

        // Detecta cambios en el switch de vibración y guarda la configuración
        binding.switchVibration.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_VIBRATION, value)
            }
        }

        // Detecta cambios en el switch de modo oscuro
        binding.switchDarkMode.setOnCheckedChangeListener { _, value ->

            // Activa o desactiva el modo oscuro según la selección del usuario
            if (value) {
                enableDarkMode()
            } else {
                disableDarkMode()
            }

            // Guarda la configuración del modo oscuro en el DataStore
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_DARK_MODE, value)
            }
        }
    }

    // Guarda el valor del volumen en el DataStore de forma asíncrona
    private suspend fun saveVolume(value: Int) {
        dataStore.edit { preference ->
            preference[intPreferencesKey(VOLUME_LVL)] = value
        }
    }

    // Guarda una opción booleana (true/false) en el DataStore según la clave proporcionada
    private suspend fun saveOptions(key: String, value: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
        }
    }

    // Recupera las configuraciones guardadas y las convierte en un objeto SettingsModel
    private fun getSettings(): Flow<SettingsModel> {
        return dataStore.data.map { preferences ->
            SettingsModel(
                volume = preferences[intPreferencesKey(VOLUME_LVL)] ?: 50, // Si no hay dato guardado, usa 50 por defecto
                bluetooth = preferences[booleanPreferencesKey(KEY_BLUETOOTH)] ?: true, // Si no hay dato, usa true por defecto
                vibration = preferences[booleanPreferencesKey(KEY_VIBRATION)] ?: true, // Si no hay dato, usa true por defecto
                darkMode = preferences[booleanPreferencesKey(KEY_DARK_MODE)] ?: false // Si no hay dato, usa false por defecto
            )
        }
    }

    // Activa el modo oscuro en la aplicación
    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        delegate.applyDayNight() // Aplica los cambios de inmediato
    }

    // Desactiva el modo oscuro en la aplicación
    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        delegate.applyDayNight() // Aplica los cambios de inmediato
    }
}
