package com.shanu.covidtracker.data.model

import CountryWiseData
import GlobalData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shanu.covidtracker.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {

    val myResponseData:MutableLiveData<Response<CountryData>> = MutableLiveData()
    val myResponseGlobal:MutableLiveData<Response<GlobalData>> = MutableLiveData()
    val myResponseCountry:MutableLiveData<Response<CountryWiseData>> = MutableLiveData()


    fun getPost(){
        viewModelScope.launch{
            val response = repository.getPost()
            myResponseData.value = response
        }
    }

    fun getGlobal(){
        viewModelScope.launch{
            val response2 = repository.getGlobal()
            myResponseGlobal.value = response2
        }
    }

    fun getCountryData(country:String){
        viewModelScope.launch{
            val response3 = repository.getCountryData(country)
            myResponseCountry.value = response3


        }
    }

}