package com.educacionit.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.educacionit.myfirstapp.screens.Challenge1Activity
import com.educacionit.myfirstapp.screens.Challenge2Activity
import com.educacionit.myfirstapp.screens.integrator_project.IntegratorProjectActivity
import com.educacionit.myfirstapp.screens.Lab1Activity
import com.educacionit.myfirstapp.screens.Lab2Activity
import com.educacionit.myfirstapp.screens.Lab3Activity
import com.educacionit.myfirstapp.screens.ToolbarExampleActivity

class MainActivity : AppCompatActivity() {
    private lateinit var lab1Button: Button
    private lateinit var lab2Button: Button
    private lateinit var lab3Button: Button
    private lateinit var challenge1Button: Button
    private lateinit var challenge2Button: Button
    private lateinit var integratorProjectButton: Button
    private lateinit var toolbarExampleButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureView()
    }

    private fun configureView() {
        lab1Button = findViewById(R.id.button_lab_1)
        lab2Button = findViewById(R.id.button_lab_2)
        lab3Button = findViewById(R.id.button_lab_3)
        challenge1Button = findViewById(R.id.button_challenge_1)
        challenge2Button = findViewById(R.id.button_challenge_2)
        integratorProjectButton = findViewById(R.id.button_integrator_project)
        toolbarExampleButton = findViewById(R.id.button_toolbar_example)

        lab1Button.setOnClickListener {
            openNewScreen(Lab1Activity::class.java)
        }
        lab2Button.setOnClickListener {
            openNewScreen(Lab2Activity::class.java)
        }
        lab3Button.setOnClickListener {
            openNewScreen(Lab3Activity::class.java)
        }
        challenge1Button.setOnClickListener {
            openNewScreen(Challenge1Activity::class.java)
        }
        challenge2Button.setOnClickListener {
            openNewScreen(Challenge2Activity::class.java)
        }

        integratorProjectButton.setOnClickListener {
            openNewScreen(IntegratorProjectActivity::class.java)
        }

        toolbarExampleButton.setOnClickListener {
            openNewScreen(ToolbarExampleActivity::class.java)
        }
    }

    private fun openNewScreen(targetActivityClass: Class<*>) {
        val newScreenIntent = Intent(this, targetActivityClass)
        startActivity(newScreenIntent)
    }

}