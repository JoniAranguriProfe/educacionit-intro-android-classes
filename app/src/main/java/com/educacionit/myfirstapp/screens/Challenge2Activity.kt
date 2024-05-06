package com.educacionit.myfirstapp.screens

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.educacionit.myfirstapp.R

class Challenge2Activity : AppCompatActivity() {
    private lateinit var maintainSessionCheckBox: CheckBox
    private lateinit var birthDayEditText: EditText
    private lateinit var createUserButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge2)
        maintainSessionCheckBox = findViewById(R.id.maintain_session_checkbox)
        birthDayEditText = findViewById(R.id.birth_day_edittext)
        createUserButton = findViewById(R.id.create_user_button)
    }

    override fun onStart() {
        super.onStart()
        createUserButton.setOnClickListener {
            // Obtener el valor de la fecha ingresada
            val originalDate = birthDayEditText.text.toString()
            // Validar que la fecha sea valida
            val isDateValid: Boolean = isValidDate(originalDate)
            // Mostrar mensaje de error o exito
            val message = if (isDateValid) "Fecha valida" else "Fecha invalida"

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
        maintainSessionCheckBox.setOnCheckedChangeListener { _, isChecked ->
            val message =
                if (isChecked) "Se mantendrá la sesion iniciada" else "Tendra que volver a loguearse"

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidDate(originalDate: String): Boolean {
        // "23/03/2024" split -> ["23", "03", "2024"]

        // Validar que no sea vacia
        if (originalDate.isEmpty()) {
            return false
        }
        // Obtener los segmentos de la fecha
        val dateSegments = originalDate.split(DATE_SEGMENT_SEPARATOR)
        // Validar que sean 3
        if (dateSegments.size != 3) {
            return false
        }
        // Convertir a Int
        val day = dateSegments[0].toInt()
        val month = dateSegments[1].toInt()
        val year = dateSegments[2].toInt()
        // Validar que sean valores validos
        // Devolver resultado
        if (day < 1 || day > 30) { // Asumimos que todos los meses tienen 30 dias para simplificar
            return false
        }
        if (month < 1 || day > 12) {
            return false
        }
        if (year < 1900 || year > 2100) {
            return false
        }
        return true
    }

    companion object {
        const val DATE_SEGMENT_SEPARATOR = "/"
    }
}