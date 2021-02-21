package com.example.day17_contactsapp.repo.dao

import androidx.room.*
import com.example.day17_contactsapp.model.Contact
import kotlinx.coroutines.flow.Flow


/*
    Marks the class as a Data Access Object.
    Data Access Objects are the main classes where you define your database interactions.
    They can include a variety of query methods.
    The class marked with @Dao should either be an interface or an abstract class.
    At compile time, Room will generate an implementation of this class when it is referenced by a Database.

    The DAO must be an interface or abstract class.

    By default, all queries must be executed on a separate thread.

    Android Room with a View - Kotlin:
    https://developer.android.com/codelabs/android-room-with-a-view-kotlin#5
 */

@Dao
interface ContactDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertContact(contact: Contact)

    /*
        A Flow is an async sequence of values

        Flow produces values one at a time (instead of all at once) that can generate
        values from async operations like network requests, database calls,
        or other async code. It supports coroutines throughout its API, so you can transform
        a flow using coroutines as well!

        https://developer.android.com/codelabs/android-room-with-a-view-kotlin#6

     */

    @Query("SELECT * FROM Contact_Table ORDER BY lastName ASC")
    fun selectAllContacts():Flow<List<Contact>>

    //https://developer.android.com/reference/androidx/room/Delete
   @Delete
    fun deleteContact(contact: Contact)


    //https://developer.android.com/reference/androidx/room/Update
    @Update
    fun updateContact(contact:Contact)




}
