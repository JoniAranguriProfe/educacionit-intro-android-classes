package com.educacionit.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var clickCounts = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainButtonInstance = findViewById<Button>(R.id.main_button)
        val mainText = findViewById<TextView>(R.id.main_text)

        mainButtonInstance.setOnClickListener {
            clickCounts++
            mainText.text = "Van $clickCounts clicks"
            Toast.makeText(this@MainActivity, "Se detectó un click", Toast.LENGTH_SHORT).show()
        }
    }

}