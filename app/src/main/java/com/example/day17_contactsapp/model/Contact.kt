package com.example.day17_contactsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact_Table")
data class Contact (

    val firstName: String,
    val lastName: String,
    val ADDRESS: Address?,
    val phone: List<String>,
    val email: List<String>,

    @PrimaryKey(autoGenerate = true)
    val id: Int

)


