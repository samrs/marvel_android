package com.example.marvel.model.api

import com.example.marvel.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelAPiService {
    val marvelApiService: MarvelApi = Retrofit.Builder()
        .baseUrl(BuildConfig.URL_MARVEL_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MarvelApi::class.java)
}