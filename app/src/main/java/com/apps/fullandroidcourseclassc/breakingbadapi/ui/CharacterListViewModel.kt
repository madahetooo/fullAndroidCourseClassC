package com.apps.fullandroidcourseclassc.breakingbadapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.apps.fullandroidcourseclassc.breakingbadapi.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharacterListViewModel(private val characterRepository: CharacterRepository)
    :ViewModel() {

    init {
        refreshDataFromRepository()
    }

    //LIST FROM LOCAL DB
    val characterList = characterRepository.characterList
    //Calling Data from Repository
    fun refreshDataFromRepository(){
        viewModelScope.launch {
            characterRepository.refreshCharacter()
        }
    }
}


class CharacterListViewModelFactory (private val characterRepository: CharacterRepository)
    : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CharacterListViewModel(characterRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}

