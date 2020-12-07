package com.shanu.covidtracker.data.repository

import com.shanu.covidtracker.data.api.ApiHelper


class Repository(private val apiHelper: ApiHelper) {
    suspend fun getCountries() = apiHelper.getCountries()
}