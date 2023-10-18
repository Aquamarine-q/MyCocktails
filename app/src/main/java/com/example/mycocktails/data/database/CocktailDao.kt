package com.example.mycocktails.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mycocktails.domain.model.Cocktail
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface CocktailDao {

    @Query("SELECT * FROM cocktail")
    fun getAll(): Single<List<Cocktail>>

    @Insert
    fun insertAll(vararg cocktails: Cocktail): Completable

    @Delete
    fun delete(cocktail: Cocktail)
}