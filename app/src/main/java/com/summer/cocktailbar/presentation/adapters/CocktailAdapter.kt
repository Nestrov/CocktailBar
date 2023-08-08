package com.summer.cocktailbar.presentation.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.summer.cocktailbar.databinding.ItemCocktailBinding
import com.summer.cocktailbar.data.CocktailDBData

class CocktailAdapter():RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>() {
    private  var cocktailDBData : List<CocktailDBData> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val binding =  ItemCocktailBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)

        return CocktailViewHolder(binding)
    }

    override fun getItemCount(): Int = cocktailDBData.size

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {

        holder.binding.tvCocktailName.text = cocktailDBData[position].name

        holder.binding.clCocktailItem.setOnClickListener {


        }

    }


    inner class CocktailViewHolder(val binding: ItemCocktailBinding) :
        RecyclerView.ViewHolder(binding.root)
}