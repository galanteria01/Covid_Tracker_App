package com.shanu.covidtracker.data.api

import GlobalData
import com.shanu.covidtracker.data.model.CountryData
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("api")
    suspend fun getGlobal() : Response<GlobalData>
    suspend fun getPost() : Response<CountryData>


}