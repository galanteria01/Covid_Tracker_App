package com.shanu.covidtracker.Activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.shanu.covidtracker.Fragments.ListFragment
import com.shanu.covidtracker.R
import kotlinx.android.synthetic.main.activity_country_view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

const val requestCode = 1009
class CountryView : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_view)
        val data = intent.extras
        countryNameSpecific.text = data!!.getString("name").toString()
        confirmedCaseCount.text = data.getString("confirmed").toString()
        recoveredCaseCount.text = data.getString("recovered").toString()
        deathCaseCount.text = data.getString("death").toString()
        lastUpdateCount.text = data.getString("lastUpdate").toString()
        imageButton.setOnClickListener{
            finish()
            Log.d("Information","onDestroy")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Information","onDestroy")
        this.finish()

    }

    override fun onResume() {
        super.onResume()
        Log.d("Information","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Information","onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Information","onRestart")
    }

}