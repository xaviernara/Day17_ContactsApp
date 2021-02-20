package com.example.day17_contactsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contact {

    private var firstName: String =""
    private var lastName: String =""
    private var ADDRESS: Address? = null
    private var phone : List<Float>? = null
    private var email : List<String>? = null

    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

}