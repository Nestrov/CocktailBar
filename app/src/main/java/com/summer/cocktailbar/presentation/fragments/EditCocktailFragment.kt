package com.summer.cocktailbar.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.summer.cocktailbar.R
import com.summer.cocktailbar.databinding.FragmentCocktailListBinding
import com.summer.cocktailbar.databinding.FragmentEditCocktailBinding


class EditCocktailFragment : Fragment() {

    private var _binding: FragmentEditCocktailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditCocktailBinding.inflate(inflater, container, false)
        return _binding?.root
    }


}