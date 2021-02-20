package com.example.day17_contactsapp.model

import androidx.room.Entity

@Entity
class Address {

    val streetAddress: String,
    val city: String,
    val state: String,
    val zipcode: Int = 0,
    val id : Int = 0
}