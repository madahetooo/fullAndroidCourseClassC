package com.apps.fullandroidcourseclassc.breakingbadapi

import android.app.Application
import com.apps.fullandroidcourseclassc.breakingbadapi.db.CharacterDatabase
import com.apps.fullandroidcourseclassc.breakingbadapi.repository.CharacterRepository

class BreakingBadApplication : Application() {

    val database by lazy {
        CharacterDatabase.createDatabase(this)
    }

    val characterRepository by lazy {
        CharacterRepository(database.createCharacterDao())
    }

}