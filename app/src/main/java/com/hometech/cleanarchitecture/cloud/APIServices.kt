package com.hometech.cleanarchitecture.cloud

import com.hometech.cleanarchitecture.pojo.CarList
import retrofit2.Response
import retrofit2.http.GET

interface APIServices {

    @GET("assignment.json")
    suspend fun getCarList(): Response<com.hometech.cleanarchitecture.utils.Response<CarList>>

}