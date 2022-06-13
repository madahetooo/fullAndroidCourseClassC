package com.apps.fullandroidcourseclassc.shoppingitemlistapp.ui

import androidx.lifecycle.ViewModel
import com.apps.fullandroidcourseclassc.shoppingitemlistapp.model.ShoppingItem
import com.apps.fullandroidcourseclassc.shoppingitemlistapp.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository) :ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItem()
}