package com.shanu.covidtracker.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shanu.covidtracker.data.api.ApiHelper
import com.shanu.covidtracker.data.repository.Repository

class MainViewModelFactory(private val apiHelper: ApiHelper):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(Repository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}