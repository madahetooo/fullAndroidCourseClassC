package com.apps.fullandroidcourseclassc.shoppingitemlistapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.fullandroidcourseclassc.databinding.ActivityShoppingBinding
import com.apps.fullandroidcourseclassc.shoppingitemlistapp.db.ShoppingDatabase
import com.apps.fullandroidcourseclassc.shoppingitemlistapp.model.ShoppingItem
import com.apps.fullandroidcourseclassc.shoppingitemlistapp.repository.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java) // MANDATORY

        val shoppingItemAdapter = ShoppingItemAdapter(listOf(), viewModel)
        binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingItems.adapter = shoppingItemAdapter

        viewModel.getAllShoppingItems().observe(this, Observer { shoppingItemsList ->
            shoppingItemAdapter.items = shoppingItemsList
            shoppingItemAdapter.notifyDataSetChanged() // update list
        })

        binding.fabAddShoppingItem.setOnClickListener {
            AddShoppingItemDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(item: ShoppingItem) {
                   viewModel.upsert(item)
                }
            }).show()
        }

    }
}