package com.summer.cocktailbar.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.CornerSize
import com.google.android.material.shape.MaterialShapeDrawable
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

        val bgMenu = _binding?.babMenu?.background as MaterialShapeDrawable

        bgMenu.shapeAppearanceModel = bgMenu.shapeAppearanceModel
            .toBuilder()
            .setTopRightCorner(CornerFamily.ROUNDED,CornerSize{ return@CornerSize 50F})
            .setTopLeftCorner(CornerFamily.ROUNDED,CornerSize{ return@CornerSize 50F})
            .build()


        return _binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}