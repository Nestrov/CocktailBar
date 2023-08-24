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
import com.summer.cocktailbar.R

import com.summer.cocktailbar.databinding.FragmentAddFirstCocktailBinding
import com.summer.cocktailbar.presentation.models.CocktailsViewModel


class AddFirstCocktailFragment : Fragment() {



    private var _binding: FragmentAddFirstCocktailBinding? = null
    //private val viewModel: CocktailsViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddFirstCocktailBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.btAddFirst?.setOnClickListener {
            parentFragmentManager.commit {
                replace<EditCocktailFragment>(R.id.fcv_container)
                setReorderingAllowed(true)
                addToBackStack(EditCocktailFragment::class.java.simpleName)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding= null
    }


}