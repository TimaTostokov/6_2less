package com.example.my.a6_2less.data.model


import com.google.gson.annotations.SerializedName

data class ContentDetails(
    @SerializedName("videoId")
    val videoId: String,
    @SerializedName("videoPublishedAt")
    val videoPublishedAt: String
)