package com.example.restapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiAdd {
    //mengambil data dari api
    @GET("data")
    fun ambilpost(): Call<ArrayList<PostRespon>>
}