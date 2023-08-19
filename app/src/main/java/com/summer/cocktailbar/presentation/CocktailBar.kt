package com.summer.cocktailbar.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider

import com.summer.cocktailbar.R
import com.summer.cocktailbar.databinding.ActivityCocktailBarBinding
import com.summer.cocktailbar.presentation.fragments.AddFirstCocktailFragment
import com.summer.cocktailbar.presentation.fragments.CocktailListFragment
import com.summer.cocktailbar.presentation.models.CocktailsViewModel

class CocktailBar : AppCompatActivity() {
    private lateinit var binding: ActivityCocktailBarBinding
    private lateinit var viewModel : CocktailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCocktailBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CocktailsViewModel::class.java]

        supportFragmentManager.commit {
            if (viewModel.isEmptyList)
            {
                replace<AddFirstCocktailFragment>( R.id.fcv_container)
                setReorderingAllowed(true)
            }
            else
            {
                replace<CocktailListFragment>( R.id.fcv_container, CocktailListFragment::class.java.simpleName)
                setReorderingAllowed(true)
            }
        }

    }


}