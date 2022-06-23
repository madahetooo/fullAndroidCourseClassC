package com.apps.fullandroidcourseclassc.breakingbadapi.db

import androidx.room.TypeConverter

object AppTypeConverters {

    @TypeConverter
    @JvmStatic
    fun arrayStringToString(value: Array<String>): String {
        return value.joinToString(" | ")
    }

    @TypeConverter
    @JvmStatic
    fun stringToArrayString(value: String): Array<String> {
        return value.split(" | ").toTypedArray()
    }
}