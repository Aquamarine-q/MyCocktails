package com.example.mycocktails.di

import android.content.Context
import androidx.room.Room
import com.example.mycocktails.data.database.CocktailDatabase
import dagger.Module
import dagger.Provides

@Module
object CocktailDatabaseModule {

    @Provides
    fun provideCocktailDatabase(applicationContext: Context) = Room.databaseBuilder(
        applicationContext,
        CocktailDatabase::class.java, "cocktails"
    ).build()
}