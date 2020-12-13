package com.shanu.covidtracker.ui.main.adapter

import CountryWiseData
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.shanu.covidtracker.Activity.CountryView

import com.shanu.covidtracker.R
import com.shanu.covidtracker.data.model.CountryData
import com.shanu.covidtracker.data.model.MainViewModel

class Adapter(private val owner:LifecycleOwner, private val context: Context, private var listOfCountries:List<CountryData.Country>, private val viewModel: MainViewModel,private val cellClickListener: CellClickListener): RecyclerView.Adapter<Adapter.ViewHolder>() {
    var countryDataScoped:CountryWiseData?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.card_ticket,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(listOfCountries[position])
        }
//        holder.itemView.setOnClickListener {
//            val country = listOfCountries[position]
//            val name = country.name.toString()
//            viewModel.getCountryData(name)
//            viewModel.myResponseCountry.observe(owner, Observer { response3 ->
//                if(response3.isSuccessful){
//                    var intent = Intent(context,CountryView::class.java)
//                    intent.putExtra("name",name)
//                    Log.d("Intent","Created intent")
//                    intent.putExtra("confirmed",response3.body()!!.confirmed.value.toString())
//                    intent.putExtra("recovered",response3.body()!!.recovered.value.toString())
//                    intent.putExtra("death",response3.body()!!.deaths.value.toString())
//                    intent.putExtra("lastUpdate",response3.body()!!.lastUpdate.toString())
//                    context.startActivity(intent)
//                }
//
//            }
//            )
//        }
        return holder.bind(listOfCountries[position])
    }

    override fun getItemCount(): Int {
        return listOfCountries.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var countryName = itemView.findViewById<TextView>(R.id.countryName)
        fun bind(country: CountryData.Country){
            countryName.text = country.name

        }

    }
    fun setData(newList:List<CountryData.Country>){
        listOfCountries = newList
        notifyDataSetChanged()
    }

    interface CellClickListener{
        fun onCellClickListener(data:CountryData.Country)
    }


}