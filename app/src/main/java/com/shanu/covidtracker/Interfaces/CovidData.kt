package com.shanu.covidtracker.Interfaces

import com.shanu.covidtracker.Models.Country
import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CovidData {
    @GET("")
    fun getCountries(@Query("5cf9dfd5-3449-485e-b5ae-70a60e997864") key:String): Call<Country>
}