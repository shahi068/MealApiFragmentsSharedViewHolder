package com.adamco.categoryfragmentssharedviewmodel.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val retrofit : Retrofit by lazy {
        Retrofit.Builder().apply{
            baseUrl("https://www.themealdb.com/api/json/v1/1/")
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

}