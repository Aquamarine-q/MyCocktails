package com.example.mycocktails.presentation.viewState

import com.example.mycocktails.domain.model.Cocktail

data class MyCocktailsViewState(
    val cocktails: List<Cocktail>,
    val isLoading: Boolean,
)