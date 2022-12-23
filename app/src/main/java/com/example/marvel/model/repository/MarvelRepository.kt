package com.example.marvel.model.repository

import com.example.marvel.model.api.MarvelApi
import com.example.marvel.model.dataclases.ResponseData
import retrofit2.Response

class MarvelRepository(private val marvelApiService: MarvelApi){

    suspend fun getCharacters(timeStamp: Long, apikey: String, hash: String, limit: Int, offset: Int): Response<ResponseData> {
        return marvelApiService.getCharacters(timeStamp, apikey, hash, limit, offset)
    }


}