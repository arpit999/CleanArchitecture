package com.hometech.cleanarchitecture

import android.os.Bundle
import android.os.Message
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hometech.cleanarchitecture.databinding.ActivityMainBinding
import com.hometech.cleanarchitecture.room.Contact

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]

        mainViewModel.contactLiveData.observe(this) { contactList ->
            updateContactList(contactList)
        }

        binding.buttonGo.setOnClickListener {
            buttonGoClickEvent()
        }


    }




    private fun updateContactList(contactList: List<Contact>) {
        var contactString = ""
        contactList.forEach {
            contactString += "${it.id}  ${it.name}  ${it.email}  ${it.phone}, \n"
        }
        binding.textViewContactList.text = contactString
    }

    private fun buttonGoClickEvent() {
        when (binding.radioGroup.checkedRadioButtonId) {
            binding.radioButtonInsert.id -> {

                binding.apply {
                    mainViewModel.insertContact(
                        Contact(
                            id = Integer.parseInt(editTextId.text.toString()),
                            name = editTextName.text.toString(),
                            email = editTextEmail.text.toString(),
                            phone = editTextPhone.text.toString()
                        )
                    )
                }
                showMessage(message = "Contact ${Integer.parseInt(binding.editTextId.text.toString())} Inserted")
            }
            binding.radioButtonUpdate.id -> {

                binding.apply {
                    mainViewModel.updateContact(
                        Contact(
                            id = Integer.parseInt(editTextId.text.toString()),
                            name = editTextName.text.toString(),
                            email = editTextEmail.text.toString(),
                            phone = editTextPhone.text.toString()
                        )
                    )
                }

                showMessage(message = "Contact ${Integer.parseInt(binding.editTextId.text.toString())} Updated")

            }
            binding.radioButtonDelete.id -> {
                if (TextUtils.isEmpty(binding.editTextId.text))
                    return
                binding.apply {
                    mainViewModel.deleteContact(
                        Contact(
                            id = Integer.parseInt(editTextId.text.toString()),
                        )
                    )
                }

                showMessage(message =  "Contact ${Integer.parseInt(binding.editTextId.text.toString())} Deleted")

            }
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }


}