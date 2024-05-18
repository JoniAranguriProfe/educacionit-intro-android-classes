package com.educacionit.myfirstapp.screens

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.educacionit.myfirstapp.R

class ToolbarExampleActivity : AppCompatActivity() {
    private lateinit var customToolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_example)
        customToolbar = findViewById(R.id.custom_toolbar)
        configureToolbar()
    }

    private fun configureToolbar() {
        setSupportActionBar(customToolbar)
        actionBar?.setHomeButtonEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu_options, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.reaction_action -> {
                showUserMessage("Se agregó una reaccion!!")
            }

            R.id.favorite_action -> {
                showUserMessage("Se agrego a la lista de favoritos..")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showUserMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}