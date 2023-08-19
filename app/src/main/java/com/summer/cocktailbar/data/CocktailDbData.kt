package com.summer.cocktailbar.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Cocktails")
data class CocktailDbData (
    @PrimaryKey(autoGenerate = true) var id :Int,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "description") var description :String,
    @ColumnInfo(name = "recipe") var recipe : String,
    @ColumnInfo(name = "photoUri") var photoUri: String
)
