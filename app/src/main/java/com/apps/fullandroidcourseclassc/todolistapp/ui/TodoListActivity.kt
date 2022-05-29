package com.apps.fullandroidcourseclassc.todolistapp.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.fullandroidcourseclassc.R
import com.apps.fullandroidcourseclassc.databinding.ActivityTodoListBinding
import com.apps.fullandroidcourseclassc.todolistapp.model.Todo
import com.apps.fullandroidcourseclassc.todolistapp.utils.TodoAdapter

class TodoListActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityTodoListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoListSingleItem = mutableListOf(Todo("eslam", false))
        val adapter = TodoAdapter(todoListSingleItem)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)


        binding.btnAddTodo.setOnClickListener {

            val newTodoTitle = binding.etAddTodo.text.toString() // Getting the todos as text
            val newTodo = Todo(newTodoTitle, false) // New TodoItem

            todoListSingleItem.add(newTodo)
            adapter.notifyDataSetChanged()
            binding.etAddTodo.text.clear()
        }


        // Drawer Code Section


        toggle = ActionBarDrawerToggle(this, binding.drawernav, R.string.open, R.string.close)
        binding.drawernav.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.myName -> Toast.makeText(this, "Mohanned", Toast.LENGTH_SHORT).show()
                R.id.myemail -> Toast.makeText(this, "example@gmail.com", Toast.LENGTH_SHORT).show()
                R.id.myphone -> Toast.makeText(this, "01110235893", Toast.LENGTH_SHORT).show()
                R.id.myPassword -> Toast.makeText(this, "Password", Toast.LENGTH_SHORT).show()

            }
            true
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}