package com.example.mycocktails

import android.app.Application
import com.example.mycocktails.di.DaggerMyCocktailsComponent
import com.example.mycocktails.di.MyCocktailsComponent

class MyCocktailsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerMyCocktailsComponent.factory().create(this)
    }

    companion object {
        lateinit var appComponent: MyCocktailsComponent
    }
}