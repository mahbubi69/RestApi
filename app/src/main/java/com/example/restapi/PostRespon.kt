package com.example.restapi

import com.google.gson.annotations.SerializedName

data class PostRespon(
    //apa saja yg mw d ambil dari data api
    //dan akan di tampilkan pada layar

    @field:SerializedName("arti")
    val arti: String,
    @field:SerializedName("asma")
    val asma: String,
    @field:SerializedName("nama")
    val nama: String,

)
