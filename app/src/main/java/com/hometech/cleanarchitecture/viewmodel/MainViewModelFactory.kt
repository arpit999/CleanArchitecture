package com.hometech.cleanarchitecture.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hometech.cleanarchitecture.repository.MainRepository
import java.lang.RuntimeException

class MainViewModelFactory(private val mainRepository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == MainViewModel::class.java) {
            return MainViewModel(mainRepository) as T
        }
        throw RuntimeException("Error Creating View Model")
    }
}