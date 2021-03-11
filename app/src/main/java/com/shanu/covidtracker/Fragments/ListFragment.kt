package com.shanu.covidtracker.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.shanu.covidtracker.R
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shanu.covidtracker.Activity.CountryView
import com.shanu.covidtracker.data.model.CountryData
import com.shanu.covidtracker.data.model.MainViewModel
import com.shanu.covidtracker.data.model.MainViewModelFactory
import com.shanu.covidtracker.data.repository.Repository
import com.shanu.covidtracker.ui.main.adapter.Adapter
import kotlinx.android.synthetic.main.fragment_list.*
import kotlin.reflect.typeOf

class ListFragment:Fragment(R.layout.fragment_list),Adapter.CellClickListener{
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
                adapter = Adapter(this,context!!,response.body()!!.countries,viewModel,this)

                recyclerView.adapter = adapter
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCellClickListener(data:CountryData.Country) {
        Toast.makeText(context,"Cell is clicked",Toast.LENGTH_SHORT).show()
        val name = data.name.toString()
            viewModel.getCountryData(name)
            viewModel.myResponseCountry.observe(this, Observer { response3 ->
                if (response3.isSuccessful) {
                    var intent = Intent(context, CountryView::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY;
                    intent.putExtra("name", name)
                    Log.d("Intent", "Created intent")
                    intent.putExtra("confirmed", response3.body()!!.confirmed.value.toString())
                    intent.putExtra("recovered", response3.body()!!.recovered.value.toString())
                    intent.putExtra("death", response3.body()!!.deaths.value.toString())
                    intent.putExtra("lastUpdate", response3.body()!!.lastUpdate.toString())
                    context!!.startActivity(intent)

                }




            })
    }


}