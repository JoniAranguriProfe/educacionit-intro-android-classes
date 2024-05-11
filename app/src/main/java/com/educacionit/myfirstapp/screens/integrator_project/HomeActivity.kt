package com.educacionit.myfirstapp.screens.integrator_project

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.educacionit.myfirstapp.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getParamsFromIntent()
    }

    private fun getParamsFromIntent() {
        val username = intent.extras?.getString(USER_PARAM_KEY)
        showUserMessage("Bienvenido $username!")
    }

    private fun showUserMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val USER_PARAM_KEY = "USER_PARAM_KEY"
        const val PASSWORD_PARAM_KEY = "PASSWORD_PARAM_KEY"
    }
}