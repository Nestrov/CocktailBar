package com.summer.cocktailbar.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CocktailBarDao {

    @Query("SELECT * FROM Cocktails")
    suspend fun getCocktails() : MutableList<CocktailDbData>

    @Query("SELECT * FROM Ingredients WHERE cocktailId = :cocktailID")
    suspend fun getIngredients(cocktailID: Int): MutableList<IngredientDbData>


    @Insert
    suspend fun insertCocktail(cocktailDBData: CocktailDbData)
    @Insert
    suspend fun insertIngredient(ingredientDBData: IngredientDbData)

    @Update
    suspend fun updateCocktail(cocktailDBData: CocktailDbData)
    @Update
    suspend fun updateIngredient(ingredientDBData: IngredientDbData)

    @Delete
    suspend fun deleteCocktail(cocktailDBData: CocktailDbData)
    @Delete
    suspend fun deleteIngredient(ingredientDBData: IngredientDbData)
}