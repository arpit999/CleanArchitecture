package com.hometech.cleanarchitecture.data.di

import com.hometech.cleanarchitecture.data.api.APIServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {
     val BASE_URL: String = "https://carfax-for-consumers.firebaseio.com/"

    @Provides
    fun provideAPIService(): APIServices {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(APIServices::class.java)
    }
}