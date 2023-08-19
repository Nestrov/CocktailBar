package com.summer.cocktailbar.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider

import com.summer.cocktailbar.R
import com.summer.cocktailbar.databinding.FragmentEditCocktailBinding
import com.summer.cocktailbar.presentation.models.CocktailsViewModel


class EditCocktailFragment : Fragment() {

    private var cocktailIndex: Int = -1

    private var _binding: FragmentEditCocktailBinding? = null
    private lateinit var viewModel: CocktailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CocktailsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditCocktailBinding.inflate(inflater, container, false)

        val bundle = arguments
        cocktailIndex = bundle?.getInt(argIndex) ?: 0

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (cocktailIndex != -1) {
            val cocktail = viewModel.cocktailList.value[cocktailIndex]

            _binding?.tilName?.editText?.setText(cocktail.name)
            _binding?.tilDescription?.editText?.setText(cocktail.description)
            _binding?.tilRecipe?.editText?.setText(cocktail.recipe)
        }

        /*
        val layoutManager = GridLayoutManager(this, 6)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                when (position) {
                    0, 1, 2 -> return 2
                    3, 4 -> return 3
                    5 -> return 6
                    else -> return 2
                }
            }
        }

        */

        _binding?.btSave?.setOnClickListener {

            if (viewModel.isEmptyList) {
                parentFragmentManager.commit {
                    replace<CocktailListFragment>(
                        R.id.fcv_container,
                        CocktailListFragment::class.java.simpleName
                    )
                    setReorderingAllowed(true)
                }
            } else {
                parentFragmentManager.popBackStack()
            }
        }

        _binding?.btCancel?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

    }

    companion object {
        const val argIndex = "ARG_INDEX"
    }

}