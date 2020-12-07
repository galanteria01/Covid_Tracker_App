package com.shanu.covidtracker.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryData(

    val countries: List<Country>
) {
    data class Country(

            val name: String,

            val iso2: String,

            val iso3: String

    )
}