package com.example.eatwhat

import com.google.gson.Gson
import org.json.JSONObject

class EatWhatWorker {
    var service = EatWhatService()

    fun getRandomMenu(
        onSuccess: (result: MenuResponse) -> Unit,
        onFailure: (errorCode: String, errorMessage: String, body: String) -> Unit
    ) {

//        service.getListRandomMenu(onSuccess = {
//            val json = JSONObject(it)
//            val array = json.getString("data")
//            val listMenuResponse: MenuResponse? = Gson().fromJson(array, MenuResponse::class.java)
//            listMenuResponse?.let { it1 -> onSuccess(it1) }
//        }, onFailure = { errorCode: String, errorMessage: String ->
//            onFailure(errorCode, errorMessage)
//        })

    }
}