package com.hometech.cleanarchitecture.data.di

import com.hometech.cleanarchitecture.data.api.APIServices
import dagger.Module
import dagger.Provides
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class AppModule {

    @Provides
    @Named("base_url")
    fun provideBaseURL(): String {
        return "https://carfax-for-consumers.firebaseio.com/"
    }

    @Provides
    @Named("base_url_amazon")
    fun provideAmazoneBaseUrl():String{
        return "https://amazon.ca"
    }

    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()

        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
        return interceptor
    }

    @Provides
    fun provideClient(interceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
        return OkHttpClient.Builder().addInterceptor(interceptor)
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient.Builder, @Named("base_url") baseUrl: String): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    @Provides
    fun provideAPIService(retrofit: Retrofit): APIServices {
        return retrofit.create(APIServices::class.java)
    }
}