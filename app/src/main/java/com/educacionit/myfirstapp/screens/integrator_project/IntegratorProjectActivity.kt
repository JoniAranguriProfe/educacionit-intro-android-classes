package com.educacionit.myfirstapp.screens.integrator_project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.educacionit.myfirstapp.R

class IntegratorProjectActivity : AppCompatActivity() {
    private lateinit var userEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var rememberUserCheckBox: CheckBox
    private lateinit var createUserButton: Button
    private lateinit var signInButton: Button
    private lateinit var termsAndConditionsClickableText: TextView
    private val logTag = javaClass.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_integrator_project)
        userEditText = findViewById(R.id.user_edittext)
        passwordEditText = findViewById(R.id.pass_edittext)
        rememberUserCheckBox = findViewById(R.id.remember_user_checkbox)
        createUserButton = findViewById(R.id.create_user_button)
        signInButton = findViewById(R.id.sign_in_button)
        termsAndConditionsClickableText = findViewById(R.id.terms_and_conditions_clickable_text)
        configureViews()
    }

    private fun configureViews() {
        signInButton.setOnClickListener {
            showUserMessage("Hello world!")
            Log.i(logTag, "Se realizó un click en el boton de iniciar sesion")

            if (validUserAndPassword()) {
                goToHomeActivity()
                return@setOnClickListener
            }
            showUserMessage("Completar datos")
        }
        termsAndConditionsClickableText.setOnClickListener {
            val termsAndConditionsIntent =
                Intent(this@IntegratorProjectActivity, TermsAndConditionsActivity::class.java)
            startActivity(termsAndConditionsIntent)
        }
    }

    private fun goToHomeActivity() {
        val userInputValue = userEditText.text.toString()
        val passwordInputValue = passwordEditText.text.toString()
        val userObject = User(username = userInputValue, password = passwordInputValue)
        val homeActivityIntent = Intent(this@IntegratorProjectActivity, HomeActivity::class.java)
        homeActivityIntent.putExtra(HomeActivity.USER_PARAM_KEY, userInputValue)
        homeActivityIntent.putExtra(HomeActivity.PASSWORD_PARAM_KEY, passwordInputValue)
        homeActivityIntent.putExtra(HomeActivity.USER_OBJECT_PARAM_KEY, userObject)
        startActivity(homeActivityIntent)
        finish()
    }

    private fun validUserAndPassword(): Boolean {
        val userInputValue = userEditText.text.toString()
        val passwordInputValue = passwordEditText.text.toString()
        return userInputValue.isNotEmpty() && passwordInputValue.isNotEmpty()
    }

    private fun showUserMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}