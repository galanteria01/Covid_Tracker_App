package com.shanu.covidtracker.data.api

import com.google.gson.GsonBuilder
import com.shanu.covidtracker.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private val retrofit by lazy{
        val gson = GsonBuilder()
                .setLenient()
                .create()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val api: CovidData by lazy{
        retrofit.create(CovidData::class.java)
    }
}