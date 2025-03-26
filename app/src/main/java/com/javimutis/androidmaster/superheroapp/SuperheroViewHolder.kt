package com.javimutis.androidmaster.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.javimutis.androidmaster.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

/*Explicación general del código:
1. SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view)
- Es un ViewHolder, que representa un solo ítem en la RecyclerView.
- Recibe un View como parámetro, que es el diseño del ítem.
2. private val binding = ItemSuperheroBinding.bind(view)
- Usa ViewBinding para acceder a los elementos de la interfaz sin usar findViewById().
3. fun bind(superheroItemResponse: SuperheroItemResponse, onItemSelected: (String) -> Unit)
Esta función recibe dos parámetros:
- superheroItemResponse: contiene la información del superhéroe.
- onItemSelected: una función que se ejecuta cuando el usuario toca el ítem.
4. binding.tvSuperheroName.text = superheroItemResponse.name
- Asigna el nombre del superhéroe al TextView de la interfaz.
5.Picasso.get().load(superheroItemResponse.superheroImage.url).into(binding.ivSuperhero)
- Usa Picasso para cargar la imagen del superhéroe desde la URL y mostrarla en ImageView.
6. binding.root.setOnClickListener { onItemSelected(superheroItemResponse.superheroId) }
- Agrega un evento de clic al ítem.
- Cuando el usuario toca el ítem, llama a onItemSelected y envía el ID del superhéroe, lo que permitirá abrir la pantalla de detalles.*/


// Clase que representa un ViewHolder para la RecyclerView.
// Un ViewHolder es una "caja" que almacena las vistas de cada ítem en la lista para mejorar el rendimiento.
class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // Utiliza ViewBinding para acceder a los elementos de la vista del ítem sin necesidad de findViewById.
    private val binding = ItemSuperheroBinding.bind(view)

    // Función que se encarga de asignar los datos del superhéroe al diseño de cada ítem en la lista.
    fun bind(superheroItemResponse: SuperheroItemResponse, onItemSelected: (String) -> Unit) {

        // Asigna el nombre del superhéroe al TextView en la interfaz.
        binding.tvSuperheroName.text = superheroItemResponse.name

        // Carga la imagen del superhéroe desde una URL usando la librería Picasso.
        Picasso.get().load(superheroItemResponse.superheroImage.url).into(binding.ivSuperhero)

        // Agrega un evento de clic al ítem para navegar a los detalles del superhéroe.
        // Cuando el usuario toca un ítem, se ejecuta la función onItemSelected con el ID del superhéroe.
        binding.root.setOnClickListener { onItemSelected(superheroItemResponse.superheroId) }
    }
}
