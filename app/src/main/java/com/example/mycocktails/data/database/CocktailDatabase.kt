package com.example.mycocktails.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mycocktails.domain.model.Cocktail

@Database(entities = [Cocktail::class], version = 1)
abstract class CocktailDatabase : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao

    companion object {

        @Volatile private var INSTANCE: CocktailDatabase? = null

        fun getInstance(context: Context): CocktailDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                CocktailDatabase::class.java, "Cocktails.db")
                .build()
    }
}