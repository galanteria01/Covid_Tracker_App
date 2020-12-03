package com.shanu.covidtracker.Models

data class Global(
    var mNewConfirmed:Long,
    var mTotalConfirmed:Long,
    var mNewDeath:Int,
    var mTotalDeath:Long,
    var mNewRecovered:Int,
    var mTotalRecovered:Long,
    var mCountries:List<Country>

)

data class Country(
    var countryName:String,
    var countryCode:String,
    var newConfirmed:Long,
    var totalConfirmed:Long,
    var newDeath:Int,
    var totalDeath:Long,
    var newRecovered:Int,
    var totalRecovered:Long
)
