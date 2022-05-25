package com.hometech.cleanarchitecture.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hometech.cleanarchitecture.cloud.APIServices
import com.hometech.cleanarchitecture.pojo.CarList
import com.hometech.cleanarchitecture.utils.ApiResponse

class MainRepository(private val apiServices: APIServices) {

    suspend fun getCarList(): ApiResponse<CarList> {
        val result = apiServices.getCarList()
        val carList = result.body() ?: return ApiResponse.Error("Error while getting carList")
        return ApiResponse.Success(carList)
    }

}