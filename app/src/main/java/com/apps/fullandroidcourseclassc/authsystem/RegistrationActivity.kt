package com.apps.fullandroidcourseclassc.authsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.fullandroidcourseclassc.databinding.ActivityRegistrationBinding
import com.apps.fullandroidcourseclassc.restuarantapp.ResturantMenuActivity
import com.apps.fullandroidcourseclassc.todolistapp.ui.TodoListActivity

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, TodoListActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.txLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}