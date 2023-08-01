package com.example.hockeyapp.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.hockeyapp.model.Game

class GameDiffUtilCallback: DiffUtil.ItemCallback<Game>( ) {
    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem.firstTimeName == newItem.firstTimeName
    }
}
