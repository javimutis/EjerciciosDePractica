package com.javimutis.androidmaster.firstapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.javimutis.androidmaster.R

// Clase para la actividad que muestra el resultado
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al método onCreate de la clase base
        enableEdgeToEdge() // Habilita el modo de borde a borde para la actividad
        setContentView(R.layout.activity_result) // Establece el diseño de la actividad usando el archivo XML

        // Configura el comportamiento de los insets de la ventana para la vista principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // Obtiene los insets de las barras del sistema
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Establece el padding de la vista principal
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets // Devuelve los insets para que se apliquen
        }

        // Encuentra el TextView donde se mostrará el resultado
        val tvResult = findViewById<TextView>(R.id.tvResult)
        // Obtiene el nombre pasado desde la actividad anterior
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        // Establece el texto del TextView para mostrar un saludo con el nombre
        tvResult.text = "Hola $name"
    }
}