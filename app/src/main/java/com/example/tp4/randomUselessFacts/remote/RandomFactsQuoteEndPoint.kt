package com.example.tp4.randomUselessFacts.remote

import com.example.tp4.randomUselessFacts.model.RandomFactsRetrofit
import retrofit2.http.GET

interface RandomFactsQuoteEndpoint {

    @GET("random.json")
    suspend fun getRandomQuote() : RandomFactsRetrofit
}