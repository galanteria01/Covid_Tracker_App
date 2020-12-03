package com.shanu.covidtracker.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shanu.covidtracker.Models.Country
import com.shanu.covidtracker.R

class Adapter(private val listOfCountries:List<Country>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.,parent,false)
        return view
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        return holder.bind(listOfCountries[position])
    }

    override fun getItemCount(): Int {
        return listOfCountries.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

}