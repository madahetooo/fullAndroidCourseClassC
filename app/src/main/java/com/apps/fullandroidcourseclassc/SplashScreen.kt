package com.apps.fullandroidcourseclassc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.apps.fullandroidcourseclassc.authsystem.LoginActivity
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
           val intent = Intent(this, LoginActivity::class.java)
           startActivity(intent)
            finish()
        },3000)

    }
}

