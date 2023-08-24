package com.summer.cocktailbar.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.summer.cocktailbar.Entity.Ingredient
import com.summer.cocktailbar.R
import com.summer.cocktailbar.databinding.FragmentEditIngredientBinding

class EditIngredientFragment(
    private val onAddIngredient : ( ingredient: Ingredient )-> Unit
):DialogFragment() {

    private var _binding: FragmentEditIngredientBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditIngredientBinding.inflate(inflater, container, false)

        dialog?.window?.setBackgroundDrawable(
            activity?.getDrawable(R.drawable.fill_dlg_background)
        )
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.btAddIngredient?.setOnClickListener {
            val atr = _binding?.tieIngredient?.text.toString() ?: ""

            if ( atr.trim() == ""  ){
                //ошибка ввода
            }
            else{
                onAddIngredient( Ingredient(0, atr))
                dismiss()
            }
        }

        _binding?.btCancelIngredient?.setOnClickListener {

            dismiss()
        }
    }


}