package com.summer.cocktailbar.presentation.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.summer.cocktailbar.databinding.ItemCocktailBinding
import com.summer.cocktailbar.entity.Cocktail

class CocktailAdapter():RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>() {
    private  var cocktails : List<Cocktail> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val binding =  ItemCocktailBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)

        return CocktailViewHolder(binding)
    }

    override fun getItemCount(): Int = cocktails.size

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {

        holder.binding.let {

        }


    }


    inner class CocktailViewHolder(val binding: ItemCocktailBinding) :
        RecyclerView.ViewHolder(binding.root)
}