package com.shanu.covidtracker.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shanu.covidtracker.R
import kotlinx.android.synthetic.main.activity_country_view.*

class CountryView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_view)
        var data = intent.extras
        countryNameAtt.text = data!!.getString("name").toString()
    }
}