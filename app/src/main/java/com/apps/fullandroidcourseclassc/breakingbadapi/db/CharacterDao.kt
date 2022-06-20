package com.apps.fullandroidcourseclassc.breakingbadapi.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apps.fullandroidcourseclassc.breakingbadapi.model.BreakingBadCharacter

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character")
    fun findAllCharacters() : LiveData<List<BreakingBadCharacter>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCharacters(characterList : List<BreakingBadCharacter>)
}