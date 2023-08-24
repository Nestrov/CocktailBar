package com.summer.cocktailbar.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import com.summer.cocktailbar.Entity.Cocktail
import com.summer.cocktailbar.R
import com.summer.cocktailbar.databinding.FragmentCocktailDetailBinding
import com.summer.cocktailbar.presentation.models.CocktailsViewModel


class CocktailDetailFragment : Fragment() {

    private var cocktailIndex: Int = -1
    private var _binding: FragmentCocktailDetailBinding? = null
    private val viewModel: CocktailsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCocktailDetailBinding.inflate(inflater, container, false)
        val bundle = arguments
        cocktailIndex = bundle?.getInt(argIndex) ?: -1
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cocktail = if (cocktailIndex == -1)
            Cocktail()
        else
            viewModel.getCocktailByIndex(cocktailIndex)

        _binding?.tvName?.text = cocktail.name
        _binding?.tvDescription?.text = cocktail.description

        val ingredient = cocktail.ingredients.fold("") { acc, ingredient ->
            if (acc == "") {
                ingredient.attributes
            } else {
                acc + "\n౼\n" + ingredient.attributes
            }
        }
        _binding?.tvIngredient?.text = ingredient


        _binding?.tvRecipe?.text = getString(R.string.hint_recipe, cocktail.recipe)

        _binding?.btEdit?.setOnClickListener {

            val bundle = Bundle()
            bundle.putInt(EditCocktailFragment.argIndex, cocktailIndex)

            parentFragmentManager.commit {
                replace<EditCocktailFragment>(R.id.fcv_container, args = bundle)
                addToBackStack(EditCocktailFragment::class.java.simpleName)
                setReorderingAllowed(true)
            }

        }


    }

    companion object {
        const val argIndex = "ARG_INDEX"
    }

}