package com.example.marvel.utils

object ConstantsUrl {

    const val URL_MARVEL_API: String = "https://gateway.marvel.com/v1/public"
    const val LIMIT: Int = 100
    const val OFFSET: Int = 0

    enum class ImageAspect(val urlParam: String){
        PORTRAIT("/portrait_"),
        STANDARD("/standard_"),
        LANDSCAPE("/landscape_")
    }

    enum class ImageAspectSize(val urlParam: String){
        SMALL("small."),
        MEDIUM("medium."),
        LARGE("large."),
        XLARGE("xlarge."),
        FANTASTIC("fantastic."),
        AMAZING("amazing."),
        INCREDIBLE("incredible.")
    }
}