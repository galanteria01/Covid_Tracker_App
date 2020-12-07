package com.shanu.covidtracker.data.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shanu.covidtracker.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {

    val myResponseData:MutableLiveData<Response<CountryData>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch{
            val response = repository.getPost()
            myResponseData.value = response
        }
    }

}