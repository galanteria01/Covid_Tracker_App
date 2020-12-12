package com.shanu.covidtracker.Fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import com.shanu.covidtracker.R
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shanu.covidtracker.data.model.MainViewModel
import com.shanu.covidtracker.data.model.MainViewModelFactory
import com.shanu.covidtracker.data.repository.Repository
import com.shanu.covidtracker.ui.main.adapter.Adapter
import kotlinx.android.synthetic.main.fragment_list.*
import kotlin.reflect.typeOf

class ListFragment:Fragment(R.layout.fragment_list){
    private lateinit var viewModel: MainViewModel
    var adapter: Adapter?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository= Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        recyclerView.layoutManager = LinearLayoutManager(context)


        viewModel.myResponseData.observe(this, Observer { response ->
            if(response.isSuccessful) {
                Log.d("Gay", response.body()!!.countries[0].name.toString())
                adapter = Adapter(this,context!!,response.body()!!.countries,viewModel)
                recyclerView.adapter = adapter


            }
        })


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}