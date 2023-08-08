package com.example.mycocktails.utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mycocktails.databinding.CocktailItemBinding
import com.example.mycocktails.domain.model.Cocktail

class CocktailAdapter(private var dataset: List<Cocktail>) :
    RecyclerView.Adapter<CocktailAdapter.ItemViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    inner class ItemViewHolder(binding: CocktailItemBinding, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(binding.root) {
        val image = binding.image
        val title = binding.title

        init {
            binding.image.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            CocktailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(adapterLayout, mListener)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        with(holder) {
            /*Glide.with(itemView.context)
                .load(item.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image)*/
            title.text = item.title
        }
    }

    fun setData(newCardList: List<Cocktail>) {
        val diffUtil = CocktailDiffUtil(dataset, newCardList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        diffResult.dispatchUpdatesTo(this)
    }
}