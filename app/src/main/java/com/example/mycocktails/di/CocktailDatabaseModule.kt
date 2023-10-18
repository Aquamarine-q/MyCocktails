package com.example.mycocktails.di

import android.content.Context
import com.example.mycocktails.data.database.CocktailDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object CocktailDatabaseModule {

    @Singleton
    @Provides
    fun provideCocktailDatabase(applicationContext: Context) =
        CocktailDatabase.getInstance(applicationContext)
}