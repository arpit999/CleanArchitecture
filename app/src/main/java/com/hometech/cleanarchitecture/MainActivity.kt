package com.hometech.cleanarchitecture

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hometech.cleanarchitecture.databinding.ActivityMainBinding
import com.hometech.cleanarchitecture.room.Contact

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]

        mainViewModel.contactLiveData.observe(this) {

            for (contact in it) {
                binding.textViewContactList.text = contact.toString()
            }
        }


        binding.buttonGo.setOnClickListener {

            when (binding.radioGroup.checkedRadioButtonId) {
                binding.radioButtonInsert.id -> {
                    Toast.makeText(this, "Insert Selected", Toast.LENGTH_SHORT).show()
                    binding.apply {
                        mainViewModel.insertContact(
                            Contact(
                                0,
                                name = editTextName.text.toString(),
                                email = editTextEmail.text.toString(),
                                phone = editTextPhone.text.toString()
                            )
                        )
                    }
                }
                binding.radioButtonUpdate.id -> {
                    Toast.makeText(this, "Update Selected", Toast.LENGTH_SHORT).show()

                }
                binding.radioButtonDelete.id -> {
                    Toast.makeText(this, "Delete Selected", Toast.LENGTH_SHORT).show()

                }
            }

//            mainViewModel.getContactList()
        }


    }


}