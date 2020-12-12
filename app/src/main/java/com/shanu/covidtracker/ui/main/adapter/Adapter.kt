package com.shanu.covidtracker.ui.main.adapter

import android.content.Context
import android.content.Intent
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

class Adapter(private val owner:LifecycleOwner,private val context: Context, private val listOfCountries:List<CountryData.Country>,private val viewModel: MainViewModel): RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.card_ticket,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val country = listOfCountries[position]
            val name = country.name.toString()

            viewModel.getCountryData(name)
            viewModel.myResponseCountry.observe(owner, Observer { response3 ->
                if(response3.isSuccessful){
                    var intent = Intent(context,CountryView::class.java)

                    intent.putExtra("name",response3.body()!!.confirmed.value.toString())
                    context.startActivity(intent)
                }

            }
            )



        }
        return holder.bind(listOfCountries[position])
    }

    override fun getItemCount(): Int {
        return listOfCountries.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var countryName = itemView.findViewById<TextView>(R.id.countryName)
        fun bind(country: CountryData.Country){
            countryName.text = country.name

        }

    }

}