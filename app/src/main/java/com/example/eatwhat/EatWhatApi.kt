package com.example.eatwhat

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface EatWhatApi {
    @GET("/v1/menu")
    fun getRandomAllMenu(): Call<ResponseBody>
}