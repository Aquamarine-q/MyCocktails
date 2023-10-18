package com.example.mycocktails.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycocktails.data.repository.CocktailRepository
import com.example.mycocktails.presentation.viewState.MyCocktailsViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MyCocktailsViewModel
@Inject constructor(private val cocktailRepository: CocktailRepository) : ViewModel() {

    private val _viewState = MutableLiveData(getDefaultState())
    val viewState: LiveData<MyCocktailsViewState> = _viewState

    fun onScreenOpened() {
        cocktailRepository.getCocktails().observeOn(AndroidSchedulers.mainThread())
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
            }
    }

    private fun getDefaultState(): MyCocktailsViewState {
        return MyCocktailsViewState(
            cocktails = emptyList(),
            isLoading = false,
        )
    }
}
