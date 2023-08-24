package com.summer.cocktailbar.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.summer.cocktailbar.Entity.Cocktail
import com.summer.cocktailbar.Entity.Ingredient
import com.summer.cocktailbar.databinding.ItemCocktailBinding

import com.summer.cocktailbar.databinding.ItemIngredientBinding

class IngredientAdapter (
    private val onDeleteClick : ( Int )-> Unit,


    ): RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>() {
    private  var ingredients : List<Ingredient> = emptyList()

    fun update(data: List<Ingredient>) {
        ingredients = data
        notifyDataSetChanged()
    }

    inner class IngredientViewHolder(val binding: ItemIngredientBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val binding =  ItemIngredientBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)

        return IngredientViewHolder(binding)
    }

    override fun getItemCount(): Int = ingredients.size

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {

        holder.binding.tvIngredient.text = ingredients[position].attributes

        holder.binding.btDelete.setOnClickListener {
            onDeleteClick(position)
        }
    }


}