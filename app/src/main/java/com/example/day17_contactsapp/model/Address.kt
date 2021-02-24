package com.example.day17_contactsapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Address (

    val streetAddress: String = "",
    val city: String = "",
    val state: String ="",
    val zipcode: Int = 0

) : Parcelable

