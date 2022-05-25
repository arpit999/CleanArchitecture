package com.hometech.cleanarchitecture.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hometech.cleanarchitecture.cloud.APIServices
import com.hometech.cleanarchitecture.pojo.CarList

class MainRepository(private val apiServices: APIServices) {

    private var _carList: MutableLiveData<CarList> = MutableLiveData()

    val carList: LiveData<CarList> get() = _carList

    suspend fun getCarList() {
        val result = apiServices.getCarList()

        result.body()?.let {
            _carList.postValue(result.body())
        }
    }

}