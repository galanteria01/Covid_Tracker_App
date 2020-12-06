package com.shanu.covidtracker.repository

import com.shanu.covidtracker.Models.CountryData
import com.shanu.covidtracker.ServiceBuilder

class Repository {
    suspend fun getPost(): CountryData{
        return ServiceBuilder.api.getCountries()
    }
}