package com.apps.fullandroidcourseclassc.todolistapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.apps.fullandroidcourseclassc.R
import com.apps.fullandroidcourseclassc.databinding.ActivityTodoListApiBinding

class TodoListApiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoListApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}