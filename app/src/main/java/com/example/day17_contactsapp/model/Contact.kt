package com.example.day17_contactsapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Entity(tableName = "Contact_Table")

@Parcelize
data class Contact (

    val firstName: String,
    val lastName: String,
    val ADDRESS: Address?,
    val phone: List<String>,
    val email: List<String>,

    @PrimaryKey(autoGenerate = true)
    val id: Int

) : Parcelable


