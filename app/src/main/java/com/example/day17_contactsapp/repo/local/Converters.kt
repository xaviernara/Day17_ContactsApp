package com.example.day17_contactsapp.repo.local

import androidx.room.TypeConverter
import com.example.day17_contactsapp.model.Address
import com.example.day17_contactsapp.model.Contact
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapter

class Converters {

    //Converter for Address object to String
    //DONT NEED type variable WHEN CONVERTING A CUSTOM OBJECT TO STRING
    @TypeConverter
    fun addressToString(address : Address):String{
        //val type = Types.newParameterizedType(Address::class.java)
        val adapter = Moshi.Builder().build().adapter<Address>(Address::class.java)
        return adapter.toJson(address)
    }


    //Converter for String to Address object
    //DONT NEED type variable WHEN CONVERTING A CUSTOM OBJECT TO STRING

    @TypeConverter
    fun stringToAddress(jsonString: String): Address? {
        //val type = Types.newParameterizedType(Address::class.java)
        val adapter = Moshi.Builder().build().adapter<Address>(Address::class.java)
        return adapter.fromJson(jsonString)
    }

    /////////////////////////////////////////////////////////////////////////////////

    //Converter for List to String
    //ONLY NEED type variable WHEN CONVERTING A LIST<>
    @TypeConverter
    fun listToString(list : List<String>):String{
        val type = Types.newParameterizedType(List::class.java,String::class.java)
        val adapter = Moshi.Builder().build().adapter<List<String>>(type)
        return adapter.toJson(list)
    }

    //Converter for String to list
    //ONLY NEED type variable WHEN CONVERTING A LIST<>
    @TypeConverter
    fun stringToPhoneList(jsonString: String): List<String>? {
        val type = Types.newParameterizedType(List::class.java,String::class.java)
        val adapter = Moshi.Builder().build().adapter<List<String>>(type)
        return adapter.fromJson(jsonString)?:listOf()
    }



















}