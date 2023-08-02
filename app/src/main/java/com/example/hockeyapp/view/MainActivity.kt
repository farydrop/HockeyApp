package com.example.hockeyapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.ActivityMainBinding
import com.example.hockeyapp.view.adapter.GameAdapter
import com.example.hockeyapp.view.adapter.HorizontalCalendarAdapter
import com.example.hockeyapp.viewModel.MainViewModel
import nl.joery.animatedbottombar.AnimatedBottomBar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private var gameAdapter: GameAdapter? = null
    private var horizontalCalendarAdapter: HorizontalCalendarAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivPrevDayButton.setOnClickListener { viewModel.onPrevMonthButtonClick() }
        binding.ivNextDayButton.setOnClickListener { viewModel.onNextMonthButtonClick() }

        setUpGameAdapter()
        setUpHorizontalCalendar()

        viewModel.monthTitleState.observe(this) { binding.tvDayTitle.text = it }

        viewModel.updateDatesAction.observe(this) {
            horizontalCalendarAdapter?.notifyDataSetChanged()
        }

        viewModel.scrollDatesToPositionAction.observe(this) { position ->
            binding.rvWeeklyCalendar.scrollToPosition(position)
        }

        viewModel.resultsOneDayState.observe(this) {
            gameAdapter?.submitList(it)
        }

        viewModel.resultsTwoDayState.observe(this) {
            gameAdapter?.submitList(it)
        }

        viewModel.resultsThreeDayState.observe(this) {
            gameAdapter?.submitList(it)
        }

        viewModel.resultsState.observe(this){
            gameAdapter?.submitList(it)
        }

        binding.bnvNav.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                Log.d("bottom_bar", "Selected index: $newIndex, title: ${newTab.title}")
                when (newIndex) {
                    1 -> startActivity(Intent(this@MainActivity, LiveActivity::class.java))

                    2 -> startActivity(Intent(this@MainActivity, TutorActivity::class.java))
                    3 -> startActivity(Intent(this@MainActivity, CoinsActivity::class.java))
                }
            }

            // An optional method that will be fired whenever an already selected tab has been selected again.
            override fun onTabReselected(index: Int, tab: AnimatedBottomBar.Tab) {
                Log.d("bottom_bar", "Reselected index: $index, title: ${tab.title}")
            }
        })
    }

    private fun setUpGameAdapter(){
        gameAdapter = GameAdapter()
        binding.rvGames.adapter = gameAdapter
    }

    private fun setUpHorizontalCalendar() {
        binding.rvWeeklyCalendar.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontalCalendarAdapter = HorizontalCalendarAdapter(
            viewModel.dates,
            object : HorizontalCalendarAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    viewModel.onDayClick(position)
                }
            }
        )
        binding.rvWeeklyCalendar.adapter = horizontalCalendarAdapter
    }
}
