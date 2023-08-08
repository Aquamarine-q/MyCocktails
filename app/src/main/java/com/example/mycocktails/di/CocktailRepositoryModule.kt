package com.example.mycocktails.di

import com.example.mycocktails.data.database.CocktailDatabase
import com.example.mycocktails.data.repository.CocktailRepository
import dagger.Module
import dagger.Provides

@Module
class CocktailRepositoryModule {

    @Provides
    fun provideCocktailRepositoryModule(database: CocktailDatabase) = CocktailRepository(database)
}