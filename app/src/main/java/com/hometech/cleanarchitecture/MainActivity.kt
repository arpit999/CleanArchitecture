package com.hometech.cleanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.hometech.cleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setText()

        binding.incrementButton.setOnClickListener {
            mainViewModel.incrementCounter()
            setText()
        }

    }

    private fun setText() {
        binding.incrementTextview.text = mainViewModel.count.toString()
    }

}