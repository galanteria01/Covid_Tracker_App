package com.shanu.covidtracker

import com.shanu.covidtracker.Interfaces.CovidData
import com.shanu.covidtracker.Utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private val retrofit by lazy{
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: CovidData by lazy{
        retrofit.create(CovidData::class.java)
    }
}