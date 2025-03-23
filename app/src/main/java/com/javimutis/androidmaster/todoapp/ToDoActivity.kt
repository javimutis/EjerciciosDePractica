package com.javimutis.androidmaster.todoapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.javimutis.androidmaster.R
import com.javimutis.androidmaster.todoapp.TaskCategory.Business
import com.javimutis.androidmaster.todoapp.TaskCategory.Other
import com.javimutis.androidmaster.todoapp.TaskCategory.Personal

// Clase principal de la actividad ToDo
class ToDoActivity : AppCompatActivity() {

    // Lista de categorías predefinidas
    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    // Lista de tareas predefinidas con diferentes categorías
    private val tasks = mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOther", Other),
    )

    // Declaración de variables para los elementos de la interfaz de usuario
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter
    private lateinit var fabAddTask: FloatingActionButton

    // Método que se ejecuta cuando la actividad se crea
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Habilita la compatibilidad con el diseño de pantalla completa
        setContentView(R.layout.activity_to_do) // Asigna el layout de la actividad

        // Ajuste de los márgenes de la ventana
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicialización de los componentes de la interfaz
        initComponent()
        initUI()
        initListeners()
    }

    // Configura los listeners de los eventos de la interfaz
    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() } // Al presionar el botón flotante, se muestra un diálogo
    }

    // Muestra un diálogo para agregar una nueva tarea
    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task) // Asigna el layout del diálogo

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId // Obtiene la categoría seleccionada
                val selectedRadioButton = rgCategories.findViewById<RadioButton>(selectedId)

                // Asigna la categoría en función de la selección del usuario
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString((R.string.todo_dialog_category_business)) -> Business
                    getString((R.string.todo_dialog_category_personal)) -> Personal
                    else -> Other
                }

                // Agrega la nueva tarea a la lista y actualiza la vista
                tasks.add(Task(etTask.text.toString(), currentCategory))
                updateTask()
                dialog.hide()
            }
        }
        dialog.show() // Muestra el diálogo
    }

    // Inicializa los componentes de la interfaz gráfica
    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    // Configura la interfaz de usuario (RecyclerViews y Adapters)
    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) { position -> updateCategories(position) }
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks) { position -> onItemSelected(position) }
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

    // Cambia el estado de selección de una tarea cuando se hace clic en ella
    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTask()
    }

    // Cambia el estado de selección de una categoría y actualiza la lista de tareas
    private fun updateCategories(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTask()
    }

    // Filtra y actualiza la lista de tareas según las categorías seleccionadas
    private fun updateTask() {
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        tasksAdapter.tasks = newTasks
        tasksAdapter.notifyDataSetChanged()
    }
}