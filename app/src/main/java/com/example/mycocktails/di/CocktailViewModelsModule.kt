package com.example.mycocktails.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mycocktails.presentation.viewmodel.MyCocktailsViewModel
import com.example.mycocktails.presentation.viewmodel.NewCocktailViewModel
import com.example.mycocktails.utils.viewmodel.ViewModelFactory
import com.example.mycocktails.utils.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CocktailViewModelsModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MyCocktailsViewModel::class)
    fun bindMyCocktailsViewModel(viewModel: MyCocktailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewCocktailViewModel::class)
    fun bindNewCocktailViewModel(viewModel: NewCocktailViewModel): ViewModel
}