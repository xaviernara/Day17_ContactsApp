package com.example.day17_contactsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact_Table")
data class Contact @JvmOverloads constructor (

private var firstName: String,
private var lastName: String,
private var ADDRESS: Address,
private var phone : List<Float>,
private var email : List<String>,

@PrimaryKey(autoGenerate = true)
private var id: Int

)
