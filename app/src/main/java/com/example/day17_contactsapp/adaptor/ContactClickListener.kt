package com.example.day17_contactsapp.adaptor

import com.example.day17_contactsapp.model.Contact

interface ContactClickListener {

    fun onClickListener(contact: Contact)
}