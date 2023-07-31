package com.example.hockeyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.ActivityLiveBinding

class LiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}