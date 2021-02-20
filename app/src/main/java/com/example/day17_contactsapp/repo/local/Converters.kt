package com.example.day17_contactsapp.repo.local

import androidx.room.TypeConverter
import com.example.day17_contactsapp.model.Address
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapter

class Converters {

    //Converter for Address object
    @TypeConverter
    fun addressFromContactsToString(addressList : List<Address>):String{
        val type = Types.newParameterizedType(List::class.java, Address::class.java)
        val adapter = Moshi.Builder().build().adapter<List<Address>>(type)
        return adapter.toJson(addressList)
    }
}