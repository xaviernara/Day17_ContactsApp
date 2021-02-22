package com.example.day17_contactsapp.repo.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.day17_contactsapp.model.Contact
import com.example.day17_contactsapp.repo.dao.ContactDAO



//Annotates class to be a Room Database with a table (entity) of the Contact class
@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converters::class)
abstract class ContactDB : RoomDatabase() {


    /*
    What is a Room database?

        Room is a database layer on top of an SQLite database.

        Room takes care of mundane tasks that you used to handle with an SQLiteOpenHelper.

        Room uses the DAO to issue queries to its database.

        By default, to avoid poor UI performance, Room doesn't allow you to issue queries on the main thread.
        When Room queries return Flow, the queries are automatically run asynchronously on a background thread.

        Room provides compile-time checks of SQLite statements.
     */



    //https://developer.android.com/codelabs/android-room-with-a-view-kotlin#7

    abstract fun contactDAO() : ContactDAO

    companion object{

        // Singleton prevents multiple instances of database opening at the same time.

        private const val  DB_NAME = "ContactDB.db"

        /*
            Marks the JVM backing field of the annotated property as volatile,
            meaning that writes to this field are immediately made visible to other threads.
         */
       
        private var INSTANCE: ContactDB? = null

        fun getDataBase(context: Context):ContactDB?{

            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null){
                synchronized(ContactDB::class.java){
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext, ContactDB::class.java, DB_NAME).build()
                    }
                }
            }

            return INSTANCE

        }



    }
}