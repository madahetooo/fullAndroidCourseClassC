package com.apps.fullandroidcourseclassc.todolistapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.fullandroidcourseclassc.R
import com.apps.fullandroidcourseclassc.databinding.ActivityTodoListBinding
import com.apps.fullandroidcourseclassc.todolistapp.model.Todo
import com.apps.fullandroidcourseclassc.todolistapp.utils.TodoAdapter

class TodoListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoListSingleItem = mutableListOf(Todo("eslam",false))
        val adapter = TodoAdapter(todoListSingleItem)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)


        binding.btnAddTodo.setOnClickListener {

            val newTodoTitle = binding.etAddTodo.text.toString() // Getting the todos as text
           val newTodo =  Todo(newTodoTitle,false) // New TodoItem

            todoListSingleItem.add(newTodo)
            adapter.notifyDataSetChanged()
            binding.etAddTodo.text.clear()
        }

    }
}