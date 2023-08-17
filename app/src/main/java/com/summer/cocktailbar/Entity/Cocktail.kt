package com.summer.cocktailbar.Entity



data class Cocktail(
    var id :Int,
    var name : String,
    var description :String,
    var recipe : String,
    var photoUri: String,
    var ingredients: MutableList<Ingredient>
)
