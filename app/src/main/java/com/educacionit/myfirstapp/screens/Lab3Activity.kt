package com.educacionit.myfirstapp.screens

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.educacionit.myfirstapp.R

class Lab3Activity : AppCompatActivity() {
    private lateinit var addButton: Button
    private lateinit var resultTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lab3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addButton = findViewById(R.id.btnSumar)
        resultTextView = findViewById(R.id.txtNumero)

        addButton.setOnClickListener {
            // Obtener el texto del textview
            val originalTextString = resultTextView.text.toString()
            // Convertir a Int
            var originalTextInt = originalTextString.toInt()
            // Incrementar el valor
            originalTextInt++
            // Convertir a string
            val finalTextString = originalTextInt.toString()
            // Reasignar el valor actualizado al textView
            resultTextView.text = finalTextString
        }
    }
}