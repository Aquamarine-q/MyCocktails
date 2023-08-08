package com.example.mycocktails.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycocktails.data.repository.CocktailRepository
import com.example.mycocktails.domain.model.Cocktail
import com.example.mycocktails.presentation.viewState.MyCocktailsViewState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MyCocktailsViewModel
@Inject constructor(private val cocktailRepository: CocktailRepository) : ViewModel() {

    private val _viewState = MutableLiveData(getDefaultState())
    val viewState: LiveData<MyCocktailsViewState> = _viewState

    fun onScreenOpened() {
        /*cocktailRepository.getCocktails()
            .subscribeOn(Schedulers.io())
            .subscribe({ listCocktails ->
                _viewState.postValue(
                    _viewState.value?.copy(
                        cocktails = listCocktails,
                        isLoading = false,
                    )
                )
            }, {
                _viewState.postValue(
                    _viewState.value?.copy(
                        isLoading = false,
                    )
                )
            }).apply {
                val compositeDisposable = CompositeDisposable()
                compositeDisposable.add(this)
            }*/
    }

    private fun getDefaultState(): MyCocktailsViewState {
        return MyCocktailsViewState(
            cocktails = listOf(
                Cocktail(id = 1, title = "Пина Колада", description = "ghbdtn", recipe = "jdjdjd"),
                Cocktail(id = 2, title = "Вода", description = "xcvcxv", recipe = "qwe") ,
                Cocktail(id = 3, title = "Лед", description = "xcvcxv", recipe = "qwe"),
                Cocktail(id = 4, title = "Минералка", description = "xcvcxv", recipe = "qwe"),
                Cocktail(id = 5, title = "Сок", description = "xcvcxv", recipe = "qwe"),
                Cocktail(id = 6, title = "Блю Курасао", description = "xcvcxv", recipe = "qwe")
            ),
            isLoading = false,
        )
    }
}
