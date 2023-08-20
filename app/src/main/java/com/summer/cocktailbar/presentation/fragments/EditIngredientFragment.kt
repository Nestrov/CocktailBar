package com.summer.cocktailbar.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.summer.cocktailbar.databinding.FragmentEditIngredientBinding

class EditIngredientFragment:DialogFragment() {

    private var _binding: FragmentEditIngredientBinding? = null
    private var result: Result? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditIngredientBinding.inflate(inflater, container, false)
        return _binding?.root
        //return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.btAddIngredient?.setOnClickListener {

            result = Result.Succes()
            dismiss()
        }

        _binding?.btCancelIngredient?.setOnClickListener {
            result = Result.Cancel()
            dismiss()
        }
    }

    companion object{
        sealed class Result {
            class Succes : Result()
            class Cancel: Result()

        }
    }
}