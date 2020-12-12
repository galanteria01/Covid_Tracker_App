package com.shanu.covidtracker.data.api

import CountryWiseData
import GlobalData
import com.shanu.covidtracker.data.model.CountryData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {

    @GET("api")
    suspend fun getGlobal() : Response<GlobalData>

    @GET("api/countries")
    suspend fun getPost() : Response<CountryData>

    @GET("api/countries/{country}")
    suspend fun getCountryData(
            @Path("country") country:String
    ):Response<CountryWiseData>

}