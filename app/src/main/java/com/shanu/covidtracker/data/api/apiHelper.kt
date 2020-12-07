package com.shanu.covidtracker.data.api


class ApiHelper(private val apiService: ApiService) {
    suspend fun getCountries() = apiService.getCountries()
}