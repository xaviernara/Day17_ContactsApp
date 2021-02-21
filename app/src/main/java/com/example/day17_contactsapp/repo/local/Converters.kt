package com.example.day17_contactsapp.repo.local

import androidx.room.TypeConverter
import com.example.day17_contactsapp.model.Address
import com.example.day17_contactsapp.model.Contact
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapter

class Converters {

    //Converter for Address object to String
    @TypeConverter
    fun addressToString(addressList : Address):String{
        val type = Types.newParameterizedType(Address::class.java)
        val adapter = Moshi.Builder().build().adapter<Address>(type)
        return adapter.toJson(addressList)
    }


    //Converter for String to Address object
    @TypeConverter
    fun stringToAddress(jsonString: String): Address? {
        val type = Types.newParameterizedType(Address::class.java)
        val adapter = Moshi.Builder().build().adapter<Address>(type)
        return adapter.fromJson(jsonString)
    }

    /////////////////////////////////////////////////////////////////////////////////

    //Converter for phone list to String
    @TypeConverter
    fun phoneListToString(phoneList : List<String>):String{
        val type = Types.newParameterizedType(List::class.java,String::class.java)
        val adapter = Moshi.Builder().build().adapter<List<String>>(type)
        return adapter.toJson(phoneList)
    }

    //Converter for String to phone list
    @TypeConverter
    fun stringToPhoneList(jsonString: String): List<String>? {
        val type = Types.newParameterizedType(List::class.java,String::class.java)
        val adapter = Moshi.Builder().build().adapter<List<String>>(type)
        return adapter.fromJson(jsonString)?:listOf()
    }




    //Converter for email list to String
    @TypeConverter
    fun emailListToString(emailList : List<String>):String{
        val type = Types.newParameterizedType(List::class.java,String::class.java)
        val adapter = Moshi.Builder().build().adapter<List<String>>(type)
        return adapter.toJson(emailList)
    }

    //Converter for String to phone list
    @TypeConverter
    fun stringToEmailList(jsonString: String): List<String>? {
        val type = Types.newParameterizedType(List::class.java,String::class.java)
        val adapter = Moshi.Builder().build().adapter<List<String>>(type)
        return adapter.fromJson(jsonString)?:listOf()
    }















}