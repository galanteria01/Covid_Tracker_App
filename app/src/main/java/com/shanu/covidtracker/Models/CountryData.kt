package com.shanu.covidtracker.Models

import com.google.gson.annotations.SerializedName

data class CountryData(
        val Countries: List<Country>,
        val Date: String,
        @SerializedName("Global")
        val GlobalStats: Global,
        val Message: String
) {
    data class Country(
            val Country: String,
            val CountryCode: String,
            val Date: String,
            val NewConfirmed: Int,
            val NewDeaths: Int,
            val NewRecovered: Int,
            @SerializedName("Premium")
            val PremiumStats: Premium,
            val Slug: String,
            val TotalConfirmed: Int,
            val TotalDeaths: Int,
            val TotalRecovered: Int
    ) {
        class Premium(
        )
    }

    data class Global(
        val NewConfirmed: Int,
        val NewDeaths: Int,
        val NewRecovered: Int,
        val TotalConfirmed: Int,
        val TotalDeaths: Int,
        val TotalRecovered: Int
    )
}