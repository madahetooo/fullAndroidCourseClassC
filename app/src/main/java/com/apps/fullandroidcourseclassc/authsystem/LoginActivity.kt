package com.apps.fullandroidcourseclassc.authsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.fullandroidcourseclassc.ui.BaseActivity
import com.apps.fullandroidcourseclassc.databinding.ActivityLoginBinding
import com.apps.fullandroidcourseclassc.ui.HomeActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.txRegister.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}