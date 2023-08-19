package com.summer.cocktailbar.presentation.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.summer.cocktailbar.Entity.Cocktail
import com.summer.cocktailbar.Entity.Ingredient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CocktailsViewModel(application: Application) :AndroidViewModel(application){


    private var _cocktailList = MutableStateFlow( mutableListOf<Cocktail>() )
    val cocktailList =  _cocktailList.asStateFlow()
    val isEmptyList :Boolean get() = cocktailList.value.size == 0




    init {
        cocktailList.value.add(
            Cocktail(
                1, "Махито",
                "Освежает летним днём",
                "всё смешать в одном высоком стакане",
                "",
                mutableListOf( Ingredient(1, "Мята"),
                    Ingredient(2, "Лайм"),
                    Ingredient(3, "Ром")
                )
            )
        )

        cocktailList.value.add(
            Cocktail(
                2, "Текилла сан райз",
                "солнце в бокале",
                "пить не спеша,гляжя на рассвет",
                "",
                mutableListOf( Ingredient(1, "Апельсиновый сок"),
                    Ingredient(2, "Текила"),
                    Ingredient(3, "Гренадин"),
                    Ingredient(4, "Гренадин"),
                    Ingredient(5, "Гренадин"),
                    Ingredient(6, "Гренадин"),
                    Ingredient(7, "Гренадин"),
                    Ingredient(8, "Гренадин")
                )
            )
        )
    }


    fun addCocktail( cocktail: Cocktail ){
        cocktailList.value.add(cocktail)
    }

    fun updateCocktail( cocktail: Cocktail  ){

    }




}