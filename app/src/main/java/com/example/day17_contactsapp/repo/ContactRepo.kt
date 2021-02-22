package com.example.day17_contactsapp.repo

import android.content.Context
import androidx.annotation.WorkerThread
import com.example.day17_contactsapp.model.Contact
import com.example.day17_contactsapp.repo.dao.ContactDAO
import com.example.day17_contactsapp.repo.local.ContactDB
import kotlinx.coroutines.flow.Flow

//https://developer.android.com/codelabs/android-room-with-a-view-kotlin#8

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
object ContactRepo {


    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    //val allContacts : Flow<List<Contact>> = contactDAO.selectAllContacts()

    //val allContacts : List<Contact>? = contactDoa?.selectAllContacts()



    suspend fun getAllContacts(context: Context): List<Contact>? {

        val contactDoa =  ContactDB.getDataBase(context)?.contactDAO()
        return contactDoa?.selectAllContacts()
    }

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
   /* @Suppress("RedundantSuspendModifier")
    @WorkerThread*/
    suspend fun insertContacts (contact: Contact,context: Context){

        val contactDoa =  ContactDB.getDataBase(context)?.contactDAO()
        contactDoa?.insertContact(contact)
    }

    suspend fun deleteContact(contact: Contact,context: Context ){
        val contactDoa =  ContactDB.getDataBase(context)?.contactDAO()
        contactDoa?.deleteContact(contact)
    }


    suspend fun updateContact(contact: Contact,context: Context){
        val contactDoa =  ContactDB.getDataBase(context)?.contactDAO()
        contactDoa?.updateContact(contact)
    }







}