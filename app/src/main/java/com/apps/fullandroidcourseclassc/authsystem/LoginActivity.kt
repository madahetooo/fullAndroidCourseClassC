package com.apps.fullandroidcourseclassc.authsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.fullandroidcourseclassc.databinding.ActivityLoginBinding
import com.apps.fullandroidcourseclassc.restuarantapp.ResturantMenuActivity
import com.apps.fullandroidcourseclassc.todolistapp.ui.TodoListActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, TodoListActivity::class.java)
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