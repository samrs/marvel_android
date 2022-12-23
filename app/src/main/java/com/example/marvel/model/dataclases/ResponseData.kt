package com.example.marvel.model.dataclases

import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("code")
    val code: Int,
    @SerializedName("attributionHTML")
    val attributionHTML: String,
    @SerializedName("attributionText")
    val attributionText: String,
    @SerializedName("data")
    val data: Data,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("status")
    val status: String
)