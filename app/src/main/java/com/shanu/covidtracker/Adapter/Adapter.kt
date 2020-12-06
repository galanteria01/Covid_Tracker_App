package com.shanu.covidtracker.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.shanu.covidtracker.Models.CountryData
import com.shanu.covidtracker.R

class Adapter(private val listOfCountries:List<CountryData>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.card_ticket,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(listOfCountries[position])
    }

    override fun getItemCount(): Int {
        return listOfCountries.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var countryName = itemView.findViewById<TextView>(R.id.countryName)
        var activeCases = itemView.findViewById<TextView>(R.id.activeCases)
        fun bind(country:CountryData){
            countryName.text = country.Countries[0].Country
            activeCases.text = country.Countries[0].TotalConfirmed.toString()
        }
    }

}