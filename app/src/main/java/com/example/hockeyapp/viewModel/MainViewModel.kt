package com.example.hockeyapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hockeyapp.R
import com.example.hockeyapp.model.Game

class MainViewModel : ViewModel() {

    val resultsState = MutableLiveData<List<Game>>()
    private val data = mutableListOf<Game>()


    init {
        data.add(
            Game(
                R.drawable.firebirds_img,
                "Coachella Valley Firebirds",
                "Hershey Bears",
                R.drawable.bears_img,
                "2 : 3",
                true
            )
        )
        data.add(
            Game(
                R.drawable.milwaukee_img,
                "Milwaukee Admirals",
                "Rochester Americans",
                R.drawable.rochester_img,
                "1 : 0",
                true
            )
        )

        data.add(
            Game(
                R.drawable.texas_img,
                "Texas Stars",
                "Calgary Wranglers",
                R.drawable.calgary_img,
                "4 : 3",
                true
            )
        )

        data.add(
            Game(
                R.drawable.toronto_img,
                "Toronto Marlies",
                "Hartford Wolf Pack",
                R.drawable.hartford_img,
                "0 : 1",
                true
            )
        )

        data.add(
            Game(
                R.drawable.manitoba_img,
                "Manitoba Moose",
                "Colorado Eagles",
                R.drawable.colorado_img,
                "5 : 0",
                true
            )
        )

        data.add(
            Game(
                R.drawable.providence_img,
                "Providence Bruins",
                "Hartford Wolf Pack",
                R.drawable.hartford_img,
                "0 : 4",
                true
            )
        )

        data.add(
            Game(
                R.drawable.utica_img,
                "Utica Comets",
                "Toronto Marlies",
                R.drawable.toronto_img,
                "1 : 4",
                true
            )
        )

        data.add(
            Game(
                R.drawable.bears_img,
                "Hershey Bears",
                "Charlotte Checkers",
                R.drawable.charlotte_img,
                "6 : 2",
                true
            )
        )

        data.add(
            Game(
                R.drawable.abbotsford_img,
                "Abbotsford Canucks",
                "Calgary Wranglers",
                R.drawable.calgary_img,
                "3 : 2",
                true
            )
        )

        data.add(
            Game(
                R.drawable.texas_img,
                "Texas Stars",
                "Rockford IceHogs",
                R.drawable.rockford_img,
                "4 : 2",
                true
            )
        )

        resultsState.value = data
    }
}