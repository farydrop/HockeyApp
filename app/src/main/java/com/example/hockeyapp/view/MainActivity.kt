package com.example.hockeyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.ActivityMainBinding
import com.example.hockeyapp.view.adapter.GameAdapter
import com.example.hockeyapp.viewModel.MainViewModel
import nl.joery.animatedbottombar.AnimatedBottomBar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private var gameAdapter: GameAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.resultsState.observe(this){
            gameAdapter = GameAdapter()
            binding.rvGames.adapter = gameAdapter
            gameAdapter?.submitList(it)
        }



    }
}