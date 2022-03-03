package com.example.yumyum.model.network

import java.lang.Exception

sealed class networkState<out R> {
    data class  Success<out T>(val data: T): networkState<T>()
    data class  Error(val exception: Exception): networkState<Nothing>()
    object  Loading : networkState<Nothing>()
}