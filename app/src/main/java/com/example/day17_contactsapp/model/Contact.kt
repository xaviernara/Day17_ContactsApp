package com.example.day17_contactsapp.model

import androidx.room.Entity

@Entity
class Contact {

    private var firstName: String,
    private var lqstName: String,
    private var ADDRESS: Address,
    private var phone[List] : List<Int>,
    private var email[List] : List<String>,
    var id: Int = 0

}