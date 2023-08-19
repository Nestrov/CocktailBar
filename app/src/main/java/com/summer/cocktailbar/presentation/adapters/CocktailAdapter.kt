package com.summer.cocktailbar.presentation.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.summer.cocktailbar.Entity.Cocktail
import com.summer.cocktailbar.databinding.ItemCocktailBinding

class CocktailAdapter(

    private val onClick : (Int , Cocktail, ItemCocktailBinding )-> Unit

):RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>() {
    private  var cocktails : List<Cocktail> = emptyList()

    fun update(data: List<Cocktail>) {
        cocktails = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val binding =  ItemCocktailBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)

        return CocktailViewHolder(binding)
    }

    override fun getItemCount(): Int = cocktails.size

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {

        holder.binding.tvCocktailName.text = cocktails[position].name

        holder.binding.clCocktailItem.setOnClickListener {
            onClick( position, cocktails[position],  holder.binding )
        }
    }




    inner class CocktailViewHolder(val binding: ItemCocktailBinding) :
        RecyclerView.ViewHolder(binding.root)
}