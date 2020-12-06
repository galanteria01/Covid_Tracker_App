package com.shanu.covidtracker

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shanu.covidtracker.Models.CountryData
import com.shanu.covidtracker.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository):ViewModel() {

    val myResponseData:MutableLiveData<CountryData> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch{
            val response = repository.getPost()
            myResponseData.value = response
        }
    }

}