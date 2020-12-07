package com.shanu.covidtracker.data.api

import com.shanu.covidtracker.data.model.CountryData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("countries")
    suspend fun getCountries() : CountryData
}