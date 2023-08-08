package com.summer.cocktailbar.entity

data class Cocktail(
    var name : String,
    var description :String,
    var ingredients :List<Ingredient>,
    var recipe : String,
    var photoUri: String
)
