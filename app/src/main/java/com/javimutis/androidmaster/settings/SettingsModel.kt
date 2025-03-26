package com.javimutis.androidmaster.settings


/*Explicaciónd el código
- data class: Es una clase especial en Kotlin que se usa para representar datos.
- Propiedades (var volume, bluetooth, darkMode, vibration): Son variables que almacenan
 configuraciones del usuario en la aplicación.
- ¿Para qué sirve esta clase? Sirve como un modelo de datos para manejar la configuración del
usuario. Cuando se necesite recuperar o guardar la configuración, esta clase será utilizada para
organizar y manipular la información.*/
data class SettingsModel(
    var volume: Int,       // Almacena el nivel de volumen como un número entero.
    var bluetooth: Boolean, // Guarda si el Bluetooth está activado (true) o desactivado (false).
    var darkMode: Boolean,  // Guarda si el Modo Oscuro está activado (true) o desactivado (false).
    var vibration: Boolean  // Indica si la vibración está activada (true) o desactivada (false).
)