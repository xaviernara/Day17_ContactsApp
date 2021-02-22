package com.example.day17_contactsapp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Address (

    val streetAddress: String = "",
    val city: String = "",
    val state: String ="",
    val zipcode: Int = 0,
    val id : Int = 0

)

