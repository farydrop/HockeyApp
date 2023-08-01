package com.example.hockeyapp.model

data class Game(
    val firstImg: Int,
    val firstTimeName: String,
    val secondTeamName: String,
    val secondImg: Int,
    val score: String,
    val locked: Boolean
)