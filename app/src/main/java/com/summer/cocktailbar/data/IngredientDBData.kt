package com.summer.cocktailbar.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Ingredients",
    foreignKeys = [ForeignKey(
        entity = CocktailDBData::class,
        childColumns = ["cocktailId"],
        parentColumns = ["id"]
    )],
    indices = [Index(value = ["cocktailId"])]
)
data class IngredientDBData(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "cocktailId") var cocktailID: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "attributes") var attributes: String
)
