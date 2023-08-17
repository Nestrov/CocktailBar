package com.summer.cocktailbar.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.summer.cocktailbar.R
import com.summer.cocktailbar.databinding.FragmentCocktailDetailBinding



class CocktailDetailFragment : Fragment() {

    private var _binding: FragmentCocktailDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_cocktail_ditail, container, false)
        _binding = FragmentCocktailDetailBinding.inflate(inflater, container, false)
        return _binding?.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.btEdit?.setOnClickListener {

            parentFragmentManager.commit {
                replace<EditCocktailFragment>(R.id.fcv_container)
                addToBackStack(EditCocktailFragment::class.java.simpleName)
                setReorderingAllowed(true)
            }

        }


    }

}