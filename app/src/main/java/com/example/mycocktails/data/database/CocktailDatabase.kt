package com.example.mycocktails.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mycocktails.domain.model.Cocktail

@Database(entities = [Cocktail::class], version = 2)
abstract class CocktailDatabase : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
}