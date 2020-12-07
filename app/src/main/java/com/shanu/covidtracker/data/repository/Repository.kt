package com.shanu.covidtracker.data.repository

import com.shanu.covidtracker.data.api.RetrofitInstance
import com.shanu.covidtracker.data.model.CountryData
import retrofit2.Response

class Repository {
    suspend fun getPost() : Response<CountryData>{
    return RetrofitInstance.api.getPost()
    }
}