package com.summer.cocktailbar.presentation.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.CornerSize
import com.google.android.material.shape.MaterialShapeDrawable
import com.summer.cocktailbar.Entity.Cocktail
import com.summer.cocktailbar.R
import com.summer.cocktailbar.databinding.FragmentCocktailListBinding
import com.summer.cocktailbar.databinding.ItemCocktailBinding
import com.summer.cocktailbar.presentation.adapters.CocktailAdapter
import com.summer.cocktailbar.presentation.models.CocktailsViewModel
import kotlinx.coroutines.launch


class CocktailListFragment : Fragment() {

    private var _binding: FragmentCocktailListBinding? = null
    private lateinit var viewModel: CocktailsViewModel

    private  val adapter = CocktailAdapter { pos, cocktail, bind ->
        onItemClick(pos, cocktail, bind)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CocktailsViewModel::class.java]
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.rvCocktailList?.adapter = adapter

        _binding?.btAdd?.setOnClickListener {

            parentFragmentManager.commit {
                replace<EditCocktailFragment>(R.id.fcv_container)
                addToBackStack(EditCocktailFragment::class.java.simpleName)
                setReorderingAllowed(true)
            }
        }


        viewLifecycleOwner.lifecycleScope.launch{
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.cocktailList.collect{
                    adapter.update(it)
                }
            }

        }

    }

    private fun onItemClick(index : Int ,  item : Cocktail, bind : ItemCocktailBinding ){

        val bundle = Bundle()
        bundle.putInt(CocktailDetailFragment.argIndex, index)

        parentFragmentManager.commit {
            replace<CocktailDetailFragment>(R.id.fcv_container, args = bundle)
            setReorderingAllowed(true)
            addToBackStack(CocktailDetailFragment::class.java.simpleName)
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this, // LifecycleOwner
            callback
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}