package com.example.hockeyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.ActivityTutorBinding

class TutorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}