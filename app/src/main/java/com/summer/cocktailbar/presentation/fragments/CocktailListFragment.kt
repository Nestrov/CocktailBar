package com.summer.cocktailbar.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.summer.cocktailbar.R
import com.summer.cocktailbar.databinding.FragmentAddFirstCocktailBinding
import com.summer.cocktailbar.databinding.FragmentCocktailListBinding


class CocktailListFragment : Fragment() {

    private var _binding: FragmentCocktailListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCocktailListBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}