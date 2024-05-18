package com.educacionit.myfirstapp.screens.integrator_project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.educacionit.myfirstapp.MainActivity
import com.educacionit.myfirstapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    override fun onStart() {
        super.onStart()
        //openMainActivityUsingHandler()
        openMainActivityUsingCoroutines()
    }

    private fun openMainActivityUsingCoroutines() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(SPLASH_DELAY)
            openMainActivity()
        }
    }

    private fun openMainActivityUsingHandler() {
        Handler(Looper.getMainLooper()).postDelayed(
            { openMainActivity() },
            SPLASH_DELAY
        )
    }

    private fun openMainActivity() {
        val mainActivityIntent = Intent(this@SplashScreenActivity, MainActivity::class.java)
        startActivity(mainActivityIntent)
        finish()
    }

    companion object {
        const val SPLASH_DELAY = 2000L
    }
}