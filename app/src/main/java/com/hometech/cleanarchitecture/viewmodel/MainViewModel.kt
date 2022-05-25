package com.hometech.cleanarchitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hometech.cleanarchitecture.pojo.CarList
import com.hometech.cleanarchitecture.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(mainRepository: MainRepository) : ViewModel() {

    val carList: LiveData<CarList> = mainRepository.carList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.getCarList()
        }
    }

}