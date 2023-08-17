package com.summer.cocktailbar.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CocktailBarDao {

    @Query("SELECT * FROM Cocktails")
    suspend fun getCocktails() : MutableList<CocktailDBData>

    @Query("SELECT * FROM Ingredients WHERE cocktailId = :cocktailID")
    suspend fun getIngredients(cocktailID: Int): MutableList<IngredientDBData>


    @Insert
    suspend fun insertCocktail(cocktailDBData: CocktailDBData)
    @Insert
    suspend fun insertIngredient(ingredientDBData: IngredientDBData)

    @Update
    suspend fun updateCocktail(cocktailDBData: CocktailDBData)
    @Update
    suspend fun updateIngredient(ingredientDBData: IngredientDBData)

    @Delete
    suspend fun deleteCocktail(cocktailDBData: CocktailDBData)
    @Delete
    suspend fun deleteIngredient(ingredientDBData: IngredientDBData)
}