package com.example.tp4.randomUselessFacts.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.tp4.randomUselessFacts.model.RandomFactsRoom
import com.example.tp4.randomUselessFacts.model.RandomFactsUi
import com.example.tp4.randomUselessFacts.repository.RandomFactsQuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RandomFactsViewModel : ViewModel() {

    private val randomFactsQuoteRepository: RandomFactsQuoteRepository by lazy { RandomFactsQuoteRepository() }
    var randomFactsQuoteLiveData: LiveData<List<RandomFactsUi>> = randomFactsQuoteRepository.selectAllRandomFactsQuote().map {
        it.toUi()
    }

    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            randomFactsQuoteRepository.fetchData()
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            randomFactsQuoteRepository.deleteAllRandomFactsQuote()
        }
    }
}

private fun List<RandomFactsRoom>.toUi(): List<RandomFactsUi> {
    return asSequence().map {
        RandomFactsUi(
            quote = it.quote
        )
    }.toList()
}