package com.summer.cocktailbar.presentation.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.summer.cocktailbar.Entity.Cocktail
import kotlinx.coroutines.flow.MutableStateFlow

class CocktailsViewModel(application: Application) :AndroidViewModel(application){


    var cocktailList = MutableStateFlow( mutableListOf<Cocktail>() )
    private val isEmptyList = true
    init {
        cocktailList.value.add(
            Cocktail(
                1, "Махито", "Освежает летним днём", "всё смешать в одном высоком стакане","", mutableListOf()
            )
        )

        cocktailList.value.add(
            Cocktail(
                2, "Текилла сан райз", "солнце в бокале", "пить не спеша,гляжя на рассвет","", mutableListOf()
            )
        )
    }

    fun isEmptyBar() = isEmptyList

    fun addCocktail( cocktail: Cocktail ){
        cocktailList.value.add(cocktail)
    }

    fun updateCocktail( cocktail: Cocktail  ){

    }

}