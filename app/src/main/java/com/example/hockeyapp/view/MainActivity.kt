package com.example.hockeyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}