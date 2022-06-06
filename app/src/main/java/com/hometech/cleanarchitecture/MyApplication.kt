package com.hometech.cleanarchitecture

import android.app.Application
import com.hometech.cleanarchitecture.data.di.AppComponent
import com.hometech.cleanarchitecture.data.di.AppModule
import com.hometech.cleanarchitecture.data.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
    }
}