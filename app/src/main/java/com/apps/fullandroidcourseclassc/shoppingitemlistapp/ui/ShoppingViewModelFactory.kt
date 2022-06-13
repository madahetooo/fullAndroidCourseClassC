package com.apps.fullandroidcourseclassc.shoppingitemlistapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.fullandroidcourseclassc.shoppingitemlistapp.repository.ShoppingRepository

class ShoppingViewModelFactory(private val repository: ShoppingRepository)
    :ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}