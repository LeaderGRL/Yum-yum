package com.example.yumyum.model.network.API

interface ApiCallback<T> {
    fun onException(error: Throwable)

    fun onError(error: String)

    fun onSucces(t: T)
}