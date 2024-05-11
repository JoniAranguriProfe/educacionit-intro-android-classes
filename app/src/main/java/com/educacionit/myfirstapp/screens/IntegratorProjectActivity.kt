package com.educacionit.myfirstapp.screens

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.educacionit.myfirstapp.R

class IntegratorProjectActivity : AppCompatActivity() {
    private lateinit var userEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var rememberUserCheckBox: CheckBox
    private lateinit var createUserButton: Button
    private lateinit var signInButton: Button
    private val logTag = javaClass.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_integrator_project)
        userEditText = findViewById(R.id.user_edittext)
        passwordEditText = findViewById(R.id.pass_edittext)
        rememberUserCheckBox = findViewById(R.id.remember_user_checkbox)
        createUserButton = findViewById(R.id.create_user_button)
        signInButton = findViewById(R.id.sign_in_button)
        configureViews()
    }

    private fun configureViews() {
        signInButton.setOnClickListener {
            showUserMessage("Hello world!")
            Log.i(logTag, "Se realizó un click en el boton de iniciar sesion")
            // Todo: Add real functionality in next commit
        }
    }

    private fun showUserMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}