package com.javimutis.androidmaster.imccalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.javimutis.androidmaster.R
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 70

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }
        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
        currentWeight -=1
            setWeight()
        }
    }

    private fun setWeight(){
        tvWeight.text = currentWeight.toString()
    }
    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
    }
}