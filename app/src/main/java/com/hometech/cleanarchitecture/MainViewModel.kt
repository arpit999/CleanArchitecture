package com.hometech.cleanarchitecture

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var count: Int = 0

    fun incrementCounter(): Int {
        count++
        return count
    }
}