package com.summer.cocktailbar.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace

import androidx.lifecycle.ViewModelProvider
import com.summer.cocktailbar.Entity.Cocktail
import com.summer.cocktailbar.Entity.Ingredient

import com.summer.cocktailbar.R
import com.summer.cocktailbar.databinding.FragmentEditCocktailBinding
import com.summer.cocktailbar.presentation.adapters.IngredientAdapter
import com.summer.cocktailbar.presentation.models.CocktailsViewModel


class EditCocktailFragment : Fragment() {

    private var cocktailIndex: Int = -1
    private lateinit var cocktail: Cocktail
    private var _binding: FragmentEditCocktailBinding? = null
    private val viewModel: CocktailsViewModel by activityViewModels()

    private var adapter = IngredientAdapter { ingredientIndex ->
        onDeleteClick(ingredientIndex)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditCocktailBinding.inflate(inflater, container, false)

        val bundle = arguments
        cocktailIndex = bundle?.getInt(argIndex) ?: -1

        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cocktail = if (cocktailIndex == -1) {
            Cocktail()
        } else {
            viewModel.getCocktailByIndex(cocktailIndex)
        }

        _binding?.tilName?.editText?.setText(cocktail.name)
        _binding?.tilDescription?.editText?.setText(cocktail.description)
        _binding?.tilRecipe?.editText?.setText(cocktail.recipe)

        adapter.update(cocktail.ingredients)
        _binding?.rvIngredients?.adapter = adapter

        _binding?.btAddIngredient?.setOnClickListener {

            val fm = parentFragmentManager
            val fr = EditIngredientFragment{
                onAddIngredient(it)
            }

            fr.show(fm, EditIngredientFragment::class.java.simpleName)
        }

        _binding?.btSave?.setOnClickListener {

            cocktail.name = _binding?.tieName?.text.toString()
            cocktail.description = _binding?.tieDescription?.text.toString()
            cocktail.recipe = _binding?.tieRecipe?.text.toString()



            if (viewModel.isEmptyList) {
                viewModel.setCocktail(cocktailIndex, cocktail)
                parentFragmentManager.commit {
                    replace<CocktailListFragment>(
                        R.id.fcv_container,
                        CocktailListFragment::class.java.simpleName
                    )
                    setReorderingAllowed(true)
                }
            } else {
                viewModel.setCocktail(cocktailIndex, cocktail)
                parentFragmentManager.popBackStack()
            }
        }

        _binding?.btCancel?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }


    private fun onDeleteClick(index: Int) {
        cocktail.ingredients[index].isActive = false

        adapter.update(cocktail.ingredients.filter {
            it.isActive
        })
    }

    private fun onAddIngredient(ingredient: Ingredient){
        cocktail.ingredients.add(ingredient)
        adapter.update(cocktail.ingredients.filter {
            it.isActive
        })
    }


    companion object {
        const val argIndex = "ARG_INDEX"
    }

}