package com.example.mycocktails.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycocktails.data.repository.CocktailRepository
import com.example.mycocktails.domain.model.Cocktail
import com.example.mycocktails.utils.livedata.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class NewCocktailViewModel
@Inject constructor(private val cocktailRepository: CocktailRepository) : ViewModel() {
    private val _viewState = MutableLiveData(false)
    val viewState: LiveData<Boolean> = _viewState

    private val _singleEvent = SingleLiveEvent<Boolean>()
    val singleEvent: LiveData<Boolean> = _singleEvent

    fun onEditButtonClicked(
        title: String,
        description: String,
        recipe: String,
    ) {
        if (title.isBlank()) {
            _viewState.value = true
        } else {
            saveCocktail(
                Cocktail(
                    title = title,
                    description = description,
                    recipe = recipe,
                )
            )
        }
    }

    private fun saveCocktail(cocktail: Cocktail) {
        cocktailRepository.saveCocktail(cocktail).observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _singleEvent.postValue(false)
            }.apply {
                val compositeDisposable = CompositeDisposable()
                compositeDisposable.add(this)
            }
    }
}