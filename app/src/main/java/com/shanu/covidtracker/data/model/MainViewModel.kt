package com.shanu.covidtracker.data.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.shanu.covidtracker.data.repository.Repository
import com.shanu.covidtracker.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {

    val myResponseData:MutableLiveData<Response<CountryData>> = MutableLiveData()

    fun getCountries() = liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try{
            emit(Resource.success(data = repository.getCountries()))

        }catch (exception:Exception){
            emit(Resource.error(data = null,message = exception.message?: "Error occurred!"))
        }

    }

}