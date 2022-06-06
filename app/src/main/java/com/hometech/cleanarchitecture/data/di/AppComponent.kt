package com.hometech.cleanarchitecture.data.di

import com.hometech.cleanarchitecture.ui.carlist.CarListFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(fragment: CarListFragment)
}