package com.hometech.cleanarchitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hometech.cleanarchitecture.pojo.CarList
import com.hometech.cleanarchitecture.pojo.Listings
import com.hometech.cleanarchitecture.repository.MainRepository
import com.hometech.cleanarchitecture.utils.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(mainRepository: MainRepository) : ViewModel() {

    private val _carList: MutableLiveData<ApiResponse<CarList>> = MutableLiveData()
    private val _listing: MutableLiveData<ApiResponse<Listings>> = MutableLiveData()

    val carList: LiveData<ApiResponse<CarList>> get() = _carList
    val listing: LiveData<ApiResponse<Listings>> get() = _listing

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _carList.postValue(mainRepository.getCarList())
        }
    }

//    fun getListing(id: String): ApiResponse<Listings>? {
//        return _listing.postValue()
//    }

}