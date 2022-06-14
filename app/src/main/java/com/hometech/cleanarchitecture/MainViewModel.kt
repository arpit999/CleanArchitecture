package com.hometech.cleanarchitecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    private var factsMutableLiveData: MutableLiveData<String> = MutableLiveData()
    val factsLiveData: LiveData<String> get() = factsMutableLiveData

    fun updateLiveData(newString: String){
        factsMutableLiveData.postValue(newString)
    }
}