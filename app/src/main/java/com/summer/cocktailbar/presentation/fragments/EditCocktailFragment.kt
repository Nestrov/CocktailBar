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
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.btSave?.setOnClickListener {

            if (viewModel.isEmptyBar()) {

                parentFragmentManager.commit {
                    replace<CocktailListFragment>(R.id.fcv_container, CocktailListFragment::class.java.simpleName)
                    setReorderingAllowed(true)
                }
            }
            else{
                parentFragmentManager.popBackStack()
            }
        }

        _binding?.btCancel?.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

    }






}