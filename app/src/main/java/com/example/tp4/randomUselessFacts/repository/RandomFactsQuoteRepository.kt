package com.example.tp4.randomUselessFacts.repository

import androidx.lifecycle.LiveData
import com.example.tp4.randomUselessFacts.model.RandomFactsRetrofit
import com.example.tp4.randomUselessFacts.model.RandomFactsRoom
import com.example.tp4.architecture.CustomApplication
import com.example.tp4.architecture.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RandomFactsQuoteRepository {

    private val randomFactsDao = CustomApplication.instance.mApplicationDatabase.randomFactsDao()

    fun selectAllRandomFactsQuote(): LiveData<List<RandomFactsRoom>> {
        return randomFactsDao.selectAll()
    }

    private suspend fun insertRandomFactsQuote(randomFactsQuote: RandomFactsRoom) =
        withContext(Dispatchers.IO) {
            randomFactsDao.insert(randomFactsQuote)
        }

    suspend fun deleteAllRandomFactsQuote() = withContext(Dispatchers.IO) {
        randomFactsDao.deleteAll()
    }

    suspend fun fetchData() {
        insertRandomFactsQuote(RetrofitBuilder.getRandomFactsQuote().getRandomQuote().toRoom())
    }
}

private fun RandomFactsRetrofit.toRoom(): RandomFactsRoom {
    return RandomFactsRoom(
        quote = quote
    )
}