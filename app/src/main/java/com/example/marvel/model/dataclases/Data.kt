package com.example.marvel.model.dataclases

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val characters: List<CharacterInfo>,
    @SerializedName("total")
    val total: Int
)