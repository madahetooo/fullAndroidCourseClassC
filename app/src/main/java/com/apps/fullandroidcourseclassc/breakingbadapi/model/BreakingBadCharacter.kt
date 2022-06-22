package com.apps.fullandroidcourseclassc.breakingbadapi.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "character")
data class BreakingBadCharacter(
    @PrimaryKey
    @SerializedName("char_id")
    val id: Int,
    val name:String,
    val birthday:String,
    val occupation: Array<String>,
    val img:String?,
    val status:String,
    val nickname:String
    ) {
}