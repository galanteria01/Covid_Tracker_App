package com.shanu.covidtracker.Fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import com.shanu.covidtracker.R
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shanu.covidtracker.data.model.MainViewModel
import com.shanu.covidtracker.data.model.MainViewModelFactory
import com.shanu.covidtracker.data.repository.Repository

class ListFragment:Fragment(R.layout.fragment_list){
    private lateinit var viewModel: MainViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponseData.observe(this, Observer { response ->
            Log.d("response",response.body()!!.countries[1].name.toString())
        })
    }


}