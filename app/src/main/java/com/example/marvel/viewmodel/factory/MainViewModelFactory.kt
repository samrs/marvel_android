package com.example.marvel.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marvel.model.api.MarvelAPiService
import com.example.marvel.model.api.MarvelApi
import com.example.marvel.model.repository.MarvelRepository
import com.example.marvel.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val marvelApiService: MarvelApi): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return modelClass.getConstructor(MarvelRepository::class.java).newInstance(MarvelRepository(marvelApiService))
        }
        throw IllegalArgumentException("Unknown class name")
    }

}