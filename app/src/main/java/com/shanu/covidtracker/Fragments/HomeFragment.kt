package com.shanu.covidtracker.Fragments

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

class HomeFragment:Fragment(R.layout.fragment_home){
    private lateinit var viewModel: MainViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.myResponseGlobal.observe(this, Observer {response2 ->
            if(response2.isSuccessful){
                Log.d("Responsive",response2.body()!!.dailySummary.toString())
            }
        })
    }

}