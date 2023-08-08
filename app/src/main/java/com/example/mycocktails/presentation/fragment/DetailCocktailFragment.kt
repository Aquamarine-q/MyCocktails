package com.example.mycocktails.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mycocktails.databinding.FragmentDetailCocktailBinding
import com.example.mycocktails.domain.model.Cocktail

class DetailCocktailFragment : Fragment() {
    private var _binding: FragmentDetailCocktailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailCocktailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cocktail = arguments?.getParcelable<Cocktail>("cocktail")
        if (cocktail != null) {
            /*Glide.with(this)
                .load(recipe.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(recipePhoto)*/
            with(binding) {
                title.text = cocktail.title
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}