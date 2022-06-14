package com.hometech.cleanarchitecture

import androidx.lifecycle.ViewModel

class MainViewModel(initialValue: Int) : ViewModel() {

    var count: Int = initialValue

    fun incrementCounter(): Int {
        count++
        return count
    }
}