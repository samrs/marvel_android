package com.example.marvel.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.marvel.BuildConfig
import com.example.marvel.model.dataclases.CharacterInfo
import com.example.marvel.model.repository.MarvelRepository
import com.example.marvel.utils.ConstantsUrl.LIMIT
import com.example.marvel.utils.ConstantsUrl.OFFSET
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

class MainViewModel(private val marvelRepository: MarvelRepository): ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    val listCharacters: LiveData<List<CharacterInfo>> =
        liveData(Dispatchers.IO) {
            val timeStamp = Date().time
            val hash = md5Hash(timeStamp.toString())
            try {
                val responseData = marvelRepository.getCharacters(timeStamp, BuildConfig.PUBLIC_KEY, hash, LIMIT, OFFSET)
                if (responseData.isSuccessful && responseData.body() != null) {
                    emit(responseData.body()!!.data.characters)
                }
                else {
                    Log.d(TAG, responseData.message())
                }
            } catch (exception: Exception) {
                Log.d(TAG, exception.toString())
            }
        }

    private fun md5Hash(timeStamp: String): String {
        val input = timeStamp + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}
