package com.example.day17_contactsapp.repo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.day17_contactsapp.model.Contact


/*
    Marks the class as a Data Access Object.
    Data Access Objects are the main classes where you define your database interactions.
    They can include a variety of query methods.
    The class marked with @Dao should either be an interface or an abstract class.
    At compile time, Room will generate an implementation of this class when it is referenced by a Database.
 */

@Dao
interface ContactDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun setContactResponse(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getContactResponse():Contact

    //@Query("INSERT INTO Contact (firstName, lastName, ADDRESS, phone, email)" )
    fun addContact():Contact




}
