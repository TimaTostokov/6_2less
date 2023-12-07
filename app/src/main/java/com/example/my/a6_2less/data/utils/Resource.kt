package com.example.my.a6_2less.data.utils

sealed class Resource<T>(
    val message: String? = null,
    val data: T? = null
) {
    class Loading<T> : Resource<T>()

    class Error<T>(message: String) : Resource<T>(
        message = message
    )

    class Success<T>(data: T) : Resource<T>(
        data = data
    )

}