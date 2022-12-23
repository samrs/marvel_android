package com.example.marvel.model.api

import com.example.marvel.model.dataclases.ResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET("characters")
    suspend fun getCharacters(@Query("ts")timeStamp: Long,
                              @Query("apikey")apikey: String,
                              @Query("hash")hash: String,
                              @Query("limit")limit: Int,
                              @Query("offset")offset: Int): Response<ResponseData>
}