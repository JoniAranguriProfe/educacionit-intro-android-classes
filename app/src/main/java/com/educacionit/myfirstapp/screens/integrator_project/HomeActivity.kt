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
        val userObject: User? = intent.extras?.getSerializable(USER_OBJECT_PARAM_KEY) as? User
        userObject?.let {
            showUserMessage("Bienvenido ${it.username} desde un objeto serializable!")
        }
    }

    private fun showUserMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val USER_PARAM_KEY = "USER_PARAM_KEY"
        const val PASSWORD_PARAM_KEY = "PASSWORD_PARAM_KEY"
        const val USER_OBJECT_PARAM_KEY = "PASSWORD_PARAM_KEY"
    }
}