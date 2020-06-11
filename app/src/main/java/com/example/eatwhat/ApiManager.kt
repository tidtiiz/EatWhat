package com.example.eatwhat

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.net.SocketTimeoutException

class ApiManager {

    private var retrofit: Retrofit? = null

    fun <T> call(serviceRequestClass: Class<T>): T {
        retrofit = Retrofit.Builder().baseUrl("www.google.com")
            .client(
                OkHttpClient.Builder()
                    .build()
            )
            .build()
        return retrofit!!.create(serviceRequestClass)
    }

    fun setCallBack(call: Call<ResponseBody>, onSuccess: (jsonData: String) -> Unit, onFailure: (errorCode: String, errorMessage: String, jsonData: String) -> Unit) {
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 200) {
                    val dataResponse = response.body()!!.string()
                    onSuccess(dataResponse)
                } else {
                    onFailure("" + response.code(), "", "")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                if (t is SocketTimeoutException) {
                    onFailure("", ErrorMessage.TIMEOUT, "")
                } else {
                    onFailure("", ErrorMessage.UNKNOWN, "")
                }
            }
        })
    }
}