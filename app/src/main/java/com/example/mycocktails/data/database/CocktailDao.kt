package com.example.mycocktails.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mycocktails.domain.model.Cocktail

@Dao
interface CocktailDao {

    @Query("SELECT * FROM cocktail")
    fun getAll(): List<Cocktail>

    @Insert
    fun insertAll(vararg cocktails: Cocktail)

    @Delete
    fun delete(cocktail: Cocktail)
}