package com.example.tp4.architecture

import com.example.tp4.randomUselessFacts.remote.RandomFactsQuoteEndpoint
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://uselessfacts.jsph.pl/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()


    fun getRandomFactsQuote(): RandomFactsQuoteEndpoint = retrofit.create(RandomFactsQuoteEndpoint::class.java)
}