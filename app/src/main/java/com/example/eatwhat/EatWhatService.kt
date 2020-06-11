package com.example.eatwhat

class EatWhatService {

    fun getListRandomMenu(onSuccess: (result: String) -> Unit, onFailure: (errorCode: String, errorMessage: String) -> Unit) {
        val api = ApiManager()
        val request = api.call(EatWhatApi::class.java)
        api.setCallBack(
            call = request.getRandomAllMenu(),
            onSuccess = { jsonData: String ->
                onSuccess(jsonData)
            },
            onFailure = { errorCode: String, errorMessage: String, _: String ->
                onFailure(errorCode, errorMessage)
            })
    }
}