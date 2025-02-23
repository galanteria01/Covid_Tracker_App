package com.shanu.covidtracker.data.repository

import CountryWiseData
import GlobalData
import com.shanu.covidtracker.data.api.RetrofitInstance
import com.shanu.covidtracker.data.model.CountryData
import retrofit2.Response

class Repository {
    suspend fun getPost() : Response<CountryData>{
        return RetrofitInstance.api.getPost()
    }
    suspend fun getGlobal(): Response<GlobalData>{
        return RetrofitInstance.api.getGlobal()
    }
    suspend fun getCountryData(country:String):Response<CountryWiseData>{
        return RetrofitInstance.api.getCountryData(country)
    }
}