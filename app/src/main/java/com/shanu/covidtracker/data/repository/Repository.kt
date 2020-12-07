package com.shanu.covidtracker.data.repository

import com.shanu.covidtracker.data.model.CountryData
import com.shanu.covidtracker.data.api.ServiceBuilder
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<CountryData> {
        return ServiceBuilder.api.getCountries()
    }
}