package com.hometech.cleanarchitecture.data.api

import com.hometech.cleanarchitecture.data.api.models.CarList
import retrofit2.Response
import retrofit2.http.GET

interface APIServices {

    @GET("assignment.json")
    suspend fun getCarList(): Response<CarList>

}