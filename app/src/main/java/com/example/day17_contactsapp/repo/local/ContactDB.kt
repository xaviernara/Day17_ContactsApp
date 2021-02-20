package com.example.day17_contactsapp.repo.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.day17_contactsapp.model.Contact
import com.example.day17_contactsapp.repo.dao.ContactDAO

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converters::class)
abstract class ContactDB : RoomDatabase() {

    abstract fun contactDAO() : ContactDAO

    companion object{

        private const val  DB_NAME = "ContactDB.db"
        private var INSTANCE: ContactDB? = null

        fun getDataBase(context: Context):ContactDB?{

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