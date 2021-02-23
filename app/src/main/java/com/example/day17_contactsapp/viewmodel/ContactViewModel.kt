package com.example.day17_contactsapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.day17_contactsapp.model.Contact
import com.example.day17_contactsapp.repo.ContactRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    val _allContactsList =  MutableLiveData<List<Contact>>()

    val contactsList: LiveData<List<Contact>>
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
            ContactRepo.insertContacts(contact,getApplication())
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
            ContactRepo.deleteContact(contact,getApplication())
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
            ContactRepo.updateContact(contact,getApplication())
        }
    }




    fun getAllContacts(){
        viewModelScope.launch(Dispatchers.IO){
            val contacts = ContactRepo.getAllContacts(getApplication())
            _allContactsList.postValue(contacts!!)
        }
    }








}