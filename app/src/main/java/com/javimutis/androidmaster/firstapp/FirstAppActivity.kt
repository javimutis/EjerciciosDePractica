package com.javimutis.androidmaster.firstapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.javimutis.androidmaster.R
// Clase principal de la actividad de la primera aplicación
class FirstAppActivity : AppCompatActivity() {
    // onCreate se llama cuando se crea la actividad de la app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al método onCreate de la clase base
        enableEdgeToEdge() // Habilita el modo de borde a borde para la actividad
        setContentView(R.layout.activity_first_app) // Establece el diseño de la actividad usando el archivo XML

        // Configura el comportamiento de los insets de la ventana para la vista principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // Obtiene los insets de las barras del sistema (como la barra de estado y la barra de navegación)
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Establece el padding de la vista principal para que no se superponga con las barras del sistema
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets // Devuelve los insets para que se apliquen
        }

        // Encuentra el botón y el campo de texto en el diseño
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart) // Botón para iniciar la siguiente actividad
        val etName = findViewById<AppCompatEditText>(R.id.etName) // Campo de texto para ingresar el nombre

        // Configura un listener para el botón que se activa al hacer clic
        btnStart.setOnClickListener {
            // Obtiene el texto ingresado en el campo de texto
            val name = etName.text.toString()

            // Verifica si el campo de texto no está vacío
            if (name.isNotEmpty()) {
                // Crea un Intent para iniciar la actividad ResultActivity
                val intent = Intent(this, ResultActivity::class.java)
                // Pasa el nombre ingresado como un extra en el Intent
                intent.putExtra("EXTRA_NAME", name)
                // Inicia la actividad ResultActivity
                startActivity(intent)
            }
        }
    }
}