package com.example.my.a6_2less.data.service

import com.example.my.a6_2less.data.model.BaseYoutubeResponce
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApiService {

    @GET("playlist")
   suspend fun getPlaylist(
        @Query("key") apikey: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: String,
    ): Response<BaseYoutubeResponce>

}