package com.example.my.a6_2less.di

import com.example.my.a6_2less.data.repo.YouTubeApiRepo
import com.example.my.a6_2less.data.service.YoutubeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient):
            Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("\"https://www.googleapis.com/youtube/v3/\"")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

@Singleton
@Provides
fun provideOkHTTPClient(interceptor: HttpLoggingInterceptor):
        OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(10L, TimeUnit.SECONDS)
    .readTimeout(10L, TimeUnit.SECONDS)
    .writeTimeout(10L, TimeUnit.SECONDS)
    .addInterceptor(interceptor)
    .build()

@Singleton
@Provides
fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

@Singleton
@Provides
fun provideYoutubeApiService(retrofit: Retrofit):
        YoutubeApiService = retrofit.create(YoutubeApiService::class.java)

@Singleton
@Provides
fun provideYoutubeRepository(
    service: YoutubeApiService
) = YouTubeApiRepo(service)


