package com.example.mycocktails.data.repository

import com.example.mycocktails.data.database.CocktailDatabase
import com.example.mycocktails.domain.model.Cocktail
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CocktailRepository
@Inject constructor(db: CocktailDatabase) {
    private val cocktailDao = db.cocktailDao()

    fun saveCocktail(cocktail: Cocktail): Completable {
        return cocktailDao.insertAll(cocktail)
            .subscribeOn(Schedulers.io())
    }

    fun getCocktails(): Single<List<Cocktail>> {
        return cocktailDao.getAll()
            .subscribeOn(Schedulers.io())
    }
}