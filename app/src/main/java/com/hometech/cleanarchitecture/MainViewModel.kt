package com.hometech.cleanarchitecture

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.hometech.cleanarchitecture.room.Contact
import com.hometech.cleanarchitecture.room.ContactDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(context: Application) : ViewModel() {

    private val database: ContactDatabase
    private var contactMutableLiveData: MutableLiveData<List<Contact>> = MutableLiveData()
    val contactLiveData: LiveData<List<Contact>> get() = contactMutableLiveData

    init {
        database = Room.databaseBuilder(context, ContactDatabase::class.java, "contactDB").build()
    }

    fun insertContact(contact: Contact) {
        viewModelScope.launch {
            database.contactDao().insertContact(contact)
        }
    }

    fun updateContact(contact: Contact) {
        viewModelScope.launch {
            database.contactDao().updateContact(contact)
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch {
            database.contactDao().updateContact(contact)
        }
    }

    fun getContactList() {
        viewModelScope.launch {
            contactMutableLiveData =
                database.contactDao().getContactList() as MutableLiveData<List<Contact>>
        }
    }


}