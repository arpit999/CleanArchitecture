package com.hometech.cleanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hometech.cleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            incrementButton.setOnClickListener {
                count++
                incrementTextview.text = count.toString()
            }
        }
    }

}