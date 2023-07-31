package com.example.hockeyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.ActivityCoinsBinding

class CoinsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoinsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}