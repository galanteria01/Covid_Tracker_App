package com.shanu.covidtracker.Interfaces

import com.shanu.covidtracker.Models.Country
import com.shanu.covidtracker.Models.CountryData
import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CovidData {

    @GET("/summary")
    suspend fun getCountries() : CountryData
}