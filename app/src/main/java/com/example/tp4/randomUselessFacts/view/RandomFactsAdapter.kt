package com.example.tp4.randomUselessFacts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tp4.randomUselessFacts.model.RandomFactsUi
import com.example.tp4.databinding.ItemRandomFactsBinding

val diffUtils = object : DiffUtil.ItemCallback<RandomFactsUi>() {
    override fun areItemsTheSame(oldItem: RandomFactsUi, newItem: RandomFactsUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RandomFactsUi, newItem: RandomFactsUi): Boolean {
        return oldItem == newItem
    }

}

class RandomFactsAdapter : ListAdapter<RandomFactsUi, RandomFactsQuoteViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomFactsQuoteViewHolder {
        return RandomFactsQuoteViewHolder(
            ItemRandomFactsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RandomFactsQuoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class RandomFactsQuoteViewHolder(
    val binding: ItemRandomFactsBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: RandomFactsUi

    fun bind(randomFactsUi: RandomFactsUi) {
        ui = randomFactsUi

        binding.itemRandomFactsQuote.text = randomFactsUi.quote
    }
}