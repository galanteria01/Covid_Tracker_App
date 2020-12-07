package com.shanu.covidtracker.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shanu.covidtracker.data.repository.Repository

class MainViewModelFactory(private val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
    }

}