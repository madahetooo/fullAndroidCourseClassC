package com.apps.fullandroidcourseclassc.shoppingitemlistapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.apps.fullandroidcourseclassc.R
import com.apps.fullandroidcourseclassc.databinding.ActivityShoppingBinding
import com.apps.fullandroidcourseclassc.shoppingitemlistapp.db.ShoppingDatabase
import com.apps.fullandroidcourseclassc.shoppingitemlistapp.repository.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)


        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)


    }
}