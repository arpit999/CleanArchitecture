package com.hometech.cleanarchitecture.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hometech.cleanarchitecture.cloud.APIServices
import com.hometech.cleanarchitecture.pojo.CarList
import com.hometech.cleanarchitecture.pojo.Listings
import com.hometech.cleanarchitecture.utils.Response

class MainRepository(private val apiServices: APIServices) {

    private var _carList: MutableLiveData<Response<CarList>> = MutableLiveData()

    val carList: LiveData<Response<CarList>> get() = _carList

    suspend fun getCarList() {
        val result = apiServices.getCarList()

        result.body()?.let {
            _carList.postValue(result.body())
        }
    }

}