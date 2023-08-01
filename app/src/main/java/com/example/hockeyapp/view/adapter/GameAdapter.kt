package com.example.hockeyapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hockeyapp.databinding.GameItemBinding
import com.example.hockeyapp.model.Game

class GameAdapter: ListAdapter<Game, GameAdapter.GameViewHolder>(GameDiffUtilCallback()) {
    class GameViewHolder(binding: GameItemBinding): RecyclerView.ViewHolder(binding.root) {
        val firstImg = binding.ivFirstTeam
        val firstTeam = binding.tvWinnerName
        val score = binding.tvResult
        val secondTeam = binding.tvLooserName
        val secondImg = binding.ivSecondTeam

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(GameItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val results = getItem(position)
        holder.firstImg.setImageResource(results.firstImg)
        holder.firstTeam.text = results.firstTimeName.toString()
        holder.score.text = results.score
        holder.secondTeam.text = results.secondTeamName
        holder.secondImg.setImageResource(results.secondImg)
    }
}