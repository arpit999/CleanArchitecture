package com.hometech.cleanarchitecture.ui.carlist

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.hometech.cleanarchitecture.data.api.APIServices
import javax.inject.Inject

class CarListViewModel : ViewModel() {

    @Inject
    lateinit var apiServices: APIServices

    init {

    }
}