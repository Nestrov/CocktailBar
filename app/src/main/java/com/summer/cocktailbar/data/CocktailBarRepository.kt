package com.summer.cocktailbar.data

import com.summer.cocktailbar.Entity.Cocktail
import com.summer.cocktailbar.Entity.Ingredient

class CocktailBarRepository(private val cocktailBarDao: CocktailBarDao) {
    suspend fun getCocktailList(): List<Cocktail> {
        val cocktails = cocktailBarDao.getCocktails().map {
            Cocktail(
                id = it.id,
                name = it.name,
                description = it.description,
                recipe = it.recipe,
                photoUri = it.photoUri,
                ingredients =  mutableListOf()
            )
        }

        cocktails.forEach {
            it.ingredients = cocktailBarDao.getIngredients(it.id).map {ingredient ->
                Ingredient(
                    id = ingredient.id,
                    attributes = ingredient.attributes
                )
            }.toMutableList()

        }

        return cocktails
    }


}