package com.apps.fullandroidcourseclassc.breakingbadapi.repository

import androidx.lifecycle.LiveData
import com.apps.fullandroidcourseclassc.breakingbadapi.db.CharacterDao
import com.apps.fullandroidcourseclassc.breakingbadapi.model.BreakingBadCharacter
import com.apps.fullandroidcourseclassc.breakingbadapi.service.BreakingBadNetwork

class CharacterRepository(private val characterDao: CharacterDao) {
    //GETTING LIST FROM LOCAL DB
    var characterList:LiveData<List<BreakingBadCharacter>> = characterDao.findAllCharacters()

     fun refreshCharacter(){
        // Getting the list from API
        val characterList = BreakingBadNetwork.serviceApi.getCharacters()

       //SAVE TO THE LOCAL DATABASE
        characterDao.insertAllCharacters(characterList)
    }
}