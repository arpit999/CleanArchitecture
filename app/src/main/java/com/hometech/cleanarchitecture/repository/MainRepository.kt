package com.hometech.cleanarchitecture.repository

import com.google.gson.Gson
import com.hometech.cleanarchitecture.cloud.APIServices
import com.hometech.cleanarchitecture.pojo.CarList
import com.hometech.cleanarchitecture.pojo.Listings
import com.hometech.cleanarchitecture.utils.ApiResponse


class MainRepository(private val apiServices: APIServices) {

    suspend fun getCarList(): ApiResponse<CarList> {
        val result = apiServices.getCarList()
//        val carList = result.body() ?: return ApiResponse.Error(result.errorBody().string().toString())
        val carList = result.body() ?: return ApiResponse.Error(
            result.message().toString()
        )
        return ApiResponse.Success(carList)
    }


    suspend fun getListing(id: String): ApiResponse<Listings>? {
        val result = apiServices.getCarList()
        val carList = result.body() ?: return ApiResponse.Error(result.message().toString())

        for (item in carList.listings) {
            if (item.id == id)
                return ApiResponse.Success(item)
        }
        return null
    }


}