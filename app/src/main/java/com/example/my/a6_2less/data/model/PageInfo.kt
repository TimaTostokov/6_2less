package com.example.my.a6_2less.data.model


import com.google.gson.annotations.SerializedName

data class PageInfo(
    @SerializedName("resultsPerPage")
    val resultsPerPage: Int,
    @SerializedName("totalResults")
    val totalResults: Int
)