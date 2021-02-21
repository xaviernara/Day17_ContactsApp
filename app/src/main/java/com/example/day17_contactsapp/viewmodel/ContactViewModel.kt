package com.example.day17_contactsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.day17_contactsapp.model.Contact
import com.example.day17_contactsapp.repo.ContactRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(private val contactRepo: ContactRepo) : ViewModel() {

    private val _allContactsList =  MutableLiveData<List<Contact>>()

    private val contactsList: LiveData<List<Contact>>
        get() = _allContactsList




    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insertContacts(contact: Contact){

        /*
       CoroutineScope tied to this ViewModel. This scope will be
       canceled when ViewModel will be cleared, i.e ViewModel.onCleared is called

       Launches a new coroutine without blocking the current thread and returns a reference to the coroutine as a Job.
       The coroutine is cancelled when the resulting job is cancelled.
       */

        viewModelScope.launch(Dispatchers.IO){
            contactRepo.insertContacts(contact)
        }


    }

    fun deleteContact(contact: Contact){

        /*
       CoroutineScope tied to this ViewModel. This scope will be
       canceled when ViewModel will be cleared, i.e ViewModel.onCleared is called

       Launches a new coroutine without blocking the current thread and returns a reference to the coroutine as a Job.
       The coroutine is cancelled when the resulting job is cancelled.
       */

        viewModelScope.launch(Dispatchers.IO){
            contactRepo.deleteContact(contact)
        }
    }


    fun updateContact(contact: Contact){

        /*
       CoroutineScope tied to this ViewModel. This scope will be
       canceled when ViewModel will be cleared, i.e ViewModel.onCleared is called

       Launches a new coroutine without blocking the current thread and returns a reference to the coroutine as a Job.
       The coroutine is cancelled when the resulting job is cancelled.
       */

        viewModelScope.launch(Dispatchers.IO){
            contactRepo.updateContact(contact)
        }
    }



    fun getAllContacts(){
        viewModelScope.launch(Dispatchers.IO){
            val contacts = contactRepo.allContacts
            _allContactsList.postValue(contacts)
        }
    }








}