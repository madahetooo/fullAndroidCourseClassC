package com.apps.fullandroidcourseclassc.todolistapiapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.fullandroidcourseclassc.databinding.ActivityTodoListApiBinding
import com.apps.fullandroidcourseclassc.todolistapiapp.service.RetrofitInstanceTodoListApi
import com.apps.fullandroidcourseclassc.todolistapiapp.ui.utils.TodoListApiAdapter
import retrofit2.HttpException
import java.io.IOException

class TodoListApiActivity : AppCompatActivity() {
    private lateinit var todoListApiAdapter: TodoListApiAdapter

    private lateinit var binding: ActivityTodoListApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView() // Calling the view

        lifecycleScope.launchWhenCreated {
            binding.progressBarTodoListApi.isVisible = true // Show Progress Bar
            val response = try {
                RetrofitInstanceTodoListApi.api.getTodos() // Getting List of Todos Data
            } catch (e: IOException) {
                Log.d("TodoListApiActivity", "You may have no internet connection")
                binding.progressBarTodoListApi.isVisible = false // Disable Progress Bar
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.d("TodoListApiActivity", "Unexpected Response")
                binding.progressBarTodoListApi.isVisible = false // Disable Progress Bar
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                todoListApiAdapter.todos = response.body()!!
            } else {
                Log.d("TodoListApiActivity", "Response is not successful")
            }
            binding.progressBarTodoListApi.isVisible = false // Disable Progress Bar


        }

    }

    private fun setupRecyclerView() = binding.rvTodoListApi.apply {
        todoListApiAdapter = TodoListApiAdapter()
        adapter = todoListApiAdapter
        layoutManager = LinearLayoutManager(this@TodoListApiActivity)
    }
}