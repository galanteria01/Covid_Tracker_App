package com.shanu.covidtracker.Fragments

import GlobalData
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shanu.covidtracker.R
import com.shanu.covidtracker.data.model.MainViewModel
import com.shanu.covidtracker.data.model.MainViewModelFactory
import com.shanu.covidtracker.data.repository.Repository
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment:Fragment(R.layout.fragment_home){
    private lateinit var viewModel: MainViewModel
    var globalData:GlobalData?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getGlobal()
        viewModel.myResponseGlobal.observe(this, Observer {response2 ->
            if(response2.isSuccessful){
                Log.d("Gay",response2.body()!!.toString())

                tvTotalCases.text = response2.body()!!.confirmed.value.toString()
                recoveredGlobalText.text = response2.body()!!.recovered.value.toString()
                deathGlobalText.text = response2.body()!!.deaths.value.toString()
            }
        })

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}