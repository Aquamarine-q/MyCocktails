package com.example.mycocktails.utils.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.mycocktails.domain.model.Cocktail

class CocktailDiffUtil(private val oldList: List<Cocktail>, private val newList: List<Cocktail>) :
    DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size


    override fun getNewListSize() = newList.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> false
            //oldList[oldItemPosition].image != newList[newItemPosition].image -> false
            oldList[oldItemPosition].title != newList[newItemPosition].title -> false
            oldList[oldItemPosition].description != newList[newItemPosition].description -> false
            oldList[oldItemPosition].recipe != newList[newItemPosition].recipe -> false
            else -> true
        }
    }
}