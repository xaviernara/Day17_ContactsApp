package com.example.day17_contactsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.day17_contactsapp.R
import com.example.day17_contactsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
    }
}