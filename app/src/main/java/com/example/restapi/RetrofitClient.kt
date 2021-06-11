package com.example.restapi


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.npoint.io/99c279bb173a6e28359c/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getDataApi(): ApiAdd {
        return retrofit.create(ApiAdd::class.java)
    }
}