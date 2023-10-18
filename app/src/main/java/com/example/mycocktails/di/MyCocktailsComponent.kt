package com.example.mycocktails.di

import android.content.Context
import com.example.mycocktails.presentation.fragment.MyCocktailsFragment
import com.example.mycocktails.presentation.fragment.NewCocktailFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CocktailDatabaseModule::class,
        CocktailRepositoryModule::class,
        CocktailViewModelsModule::class,
    ]
)
interface MyCocktailsComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): MyCocktailsComponent
    }

    fun inject(fragment: MyCocktailsFragment)
    fun inject(fragment: NewCocktailFragment)
}