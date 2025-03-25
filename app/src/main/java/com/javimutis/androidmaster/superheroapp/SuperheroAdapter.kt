package com.javimutis.androidmaster.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javimutis.androidmaster.R

/*Explicación clave:
1. Clase SuperheroAdapter
- Es un adaptador para manejar una lista de superhéroes en un RecyclerView.
- Hereda de RecyclerView.Adapter<SuperheroViewHolder>, lo que significa que usa un ViewHolder personalizado.
2. Parámetros del constructor
- superheroList: Es la lista de superhéroes que se mostrarán en pantalla.
- onItemSelected: Es una función lambda que se ejecuta cuando se selecciona un ítem.
3. updateList()
- Actualiza la lista con nuevos datos y notifica al RecyclerView para refrescar la vista.
4. onCreateViewHolder()
- Se ejecuta cuando se necesita crear un nuevo ViewHolder.
- Usa LayoutInflater para convertir el archivo XML item_superhero.xml en una vista.
5. onBindViewHolder()
- Se ejecuta cada vez que un ViewHolder necesita mostrar datos.
- Llama al método bind() del ViewHolder, pasándole el superhéroe en la posición correspondiente.
6. getItemCount()
- Devuelve el número total de elementos en la lista.*/



// Adaptador para una lista de superhéroes en un RecyclerView.
class SuperheroAdapter(
    // Lista de superhéroes que se mostrará en el RecyclerView.
    var superheroList: List<SuperheroItemResponse> = emptyList(),

    // Función lambda que se ejecutará cuando un ítem sea seleccionado.
    private val onItemSelected: (String) -> Unit
) : RecyclerView.Adapter<SuperheroViewHolder>() { // Hereda de RecyclerView.Adapter

    // Función para actualizar la lista de superhéroes con nuevos datos.
    fun updateList(list: List<SuperheroItemResponse>) {
        superheroList = list // Reemplaza la lista actual con la nueva.
        notifyDataSetChanged() // Notifica al RecyclerView que los datos han cambiado.
    }

    // Método que crea un nuevo ViewHolder (representación de un ítem en la lista).
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            // Infla el diseño del ítem de la lista (item_superhero.xml).
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    // Método que asocia los datos con un ViewHolder en una posición específica.
    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {
        // Llama a la función bind() del ViewHolder, pasando el superhéroe correspondiente y la acción al hacer clic.
        viewholder.bind(superheroList[position], onItemSelected)
    }

    // Método que devuelve la cantidad de elementos en la lista.
    override fun getItemCount() = superheroList.size
}
