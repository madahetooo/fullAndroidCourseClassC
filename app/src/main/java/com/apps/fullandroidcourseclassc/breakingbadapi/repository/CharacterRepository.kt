package com.apps.fullandroidcourseclassc.breakingbadapi.repository

import androidx.lifecycle.LiveData
import com.apps.fullandroidcourseclassc.breakingbadapi.db.CharacterDao
import com.apps.fullandroidcourseclassc.breakingbadapi.model.BreakingBadCharacter
import com.apps.fullandroidcourseclassc.breakingbadapi.service.BreakingBadNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterRepository(private val characterDao: CharacterDao) {
    //GETTING LIST FROM LOCAL DB
    var characterList:LiveData<List<BreakingBadCharacter>> = characterDao.findAllCharacters()

     suspend fun refreshCharacter(){
         withContext(Dispatchers.IO){
             // Getting the list from API
             val characterList = BreakingBadNetwork.serviceApi.getCharacters()

             //SAVE TO THE LOCAL DATABASE
             characterDao.insertAllCharacters(characterList)
         }

    }
}