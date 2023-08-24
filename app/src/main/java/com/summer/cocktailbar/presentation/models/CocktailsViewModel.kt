package com.summer.cocktailbar.presentation.models


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.summer.cocktailbar.Entity.Cocktail
import com.summer.cocktailbar.Entity.Ingredient

class CocktailsViewModel() : ViewModel() {


    var cocktailList: MutableLiveData<MutableList<Cocktail>> = MutableLiveData()

    val isEmptyList: Boolean get() = cocktailList.value?.size == 0


    init {
        cocktailList.value = mutableListOf(
            Cocktail(
                1, "Махито",
                "Освежает летним днём",
                "всё смешать в одном высоком стакане",
                "",
                mutableListOf(
                    Ingredient(1, "Мята"),
                    Ingredient(2, "Лайм"),
                    Ingredient(3, "Ром")
                )
            ),
            Cocktail(
                2, "Текилла сан райз",
                "солнце в бокале",
                "пить не спеша,гляжя на рассвет",
                "",
                mutableListOf(
                    Ingredient(1, "Апельсиновый сок"),
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


    fun setCocktail(index: Int, cocktail: Cocktail) {

        val list = cocktailList.value?.toMutableList()  ?: mutableListOf<Cocktail>()

        if (index == -1) {
            list.add(cocktail)
        } else {
            list[index] = cocktail
        }
        cocktailList.postValue(list)
    }

    fun getCocktailByIndex(index: Int): Cocktail {
        return cocktailList.value?.get(index)?.copy() ?: Cocktail()
    }


}