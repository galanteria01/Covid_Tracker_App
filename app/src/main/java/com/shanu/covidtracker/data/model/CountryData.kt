package com.shanu.covidtracker.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryData(
        @Expose
        @SerializedName("countries")
    val countries: List<Country>
) {
    data class Country(
            @Expose
            @SerializedName("name")
            val name: String,
            @Expose
            @SerializedName("iso2")
            val iso2: String,
            @Expose
            @SerializedName("iso3")
            val iso3: String

    )
}