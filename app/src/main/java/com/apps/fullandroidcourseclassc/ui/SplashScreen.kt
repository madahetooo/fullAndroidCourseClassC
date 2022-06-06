package com.apps.fullandroidcourseclassc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.apps.fullandroidcourseclassc.authsystem.LoginActivity
import com.apps.fullandroidcourseclassc.coroutineapp.CoroutineActivity
import com.apps.fullandroidcourseclassc.databinding.ActivitySplashScreenBinding

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        Handler().postDelayed({
           val intent = Intent(this, CoroutineActivity::class.java)
           startActivity(intent)

            finish()
        },3000)

    }
}

