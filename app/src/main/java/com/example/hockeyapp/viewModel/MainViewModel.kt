package com.example.hockeyapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hockeyapp.R
import com.example.hockeyapp.common.SingleLiveData
import com.example.hockeyapp.common.SingleLiveDataEmpty
import com.example.hockeyapp.model.Date
import com.example.hockeyapp.model.Game
import com.example.hockeyapp.model.HorizontalCalendarItem
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainViewModel : ViewModel() {

    private var selectedDate = Calendar.getInstance(Locale.ENGLISH).let { currentDateCalendar ->
        Date(
            day = currentDateCalendar[Calendar.DAY_OF_MONTH],
            month = currentDateCalendar[Calendar.MONTH],
            year = currentDateCalendar[Calendar.YEAR]
        )
    }

    val dates = mutableListOf<HorizontalCalendarItem>()
    var scrollDayPosition: Int? = null
    val monthTitleState = MutableLiveData<String>()
    val scrollDatesToPositionAction = SingleLiveData<Int>()
    val updateDatesAction = SingleLiveDataEmpty()

    val resultsState = MutableLiveData<List<Game>>()
    val resultsOneDayState = MutableLiveData<List<Game>>()
    val resultsTwoDayState = MutableLiveData<List<Game>>()
    val resultsThreeDayState = MutableLiveData<List<Game>>()
    private val listOne = mutableListOf<Game>()
    private val listTwo = mutableListOf<Game>()
    private val listThree = mutableListOf<Game>()


    init {
        setUpCalendar(0)
        listOne.add(
            Game(
                R.drawable.firebirds_img,
                "Coachella Valley Firebirds",
                "Hershey Bears",
                R.drawable.bears_img,
                "2 : 3",
                true
            )
        )
        listOne.add(
            Game(
                R.drawable.milwaukee_img,
                "Milwaukee Admirals",
                "Rochester Americans",
                R.drawable.rochester_img,
                "1 : 0",
                true
            )
        )

        listOne.add(
            Game(
                R.drawable.texas_img,
                "Texas Stars",
                "Calgary Wranglers",
                R.drawable.calgary_img,
                "4 : 3",
                true
            )
        )

        listOne.add(
            Game(
                R.drawable.toronto_img,
                "Toronto Marlies",
                "Hartford Wolf Pack",
                R.drawable.hartford_img,
                "0 : 1",
                true
            )
        )

        listTwo.add(
            Game(
                R.drawable.manitoba_img,
                "Manitoba Moose",
                "Colorado Eagles",
                R.drawable.colorado_img,
                "5 : 0",
                true
            )
        )

        listTwo.add(
            Game(
                R.drawable.providence_img,
                "Providence Bruins",
                "Hartford Wolf Pack",
                R.drawable.hartford_img,
                "0 : 4",
                true
            )
        )

        listTwo.add(
            Game(
                R.drawable.utica_img,
                "Utica Comets",
                "Toronto Marlies",
                R.drawable.toronto_img,
                "1 : 4",
                true
            )
        )

        listThree.add(
            Game(
                R.drawable.bears_img,
                "Hershey Bears",
                "Charlotte Checkers",
                R.drawable.charlotte_img,
                "6 : 2",
                true
            )
        )

        listThree.add(
            Game(
                R.drawable.abbotsford_img,
                "Abbotsford Canucks",
                "Calgary Wranglers",
                R.drawable.calgary_img,
                "3 : 2",
                true
            )
        )

        listThree.add(
            Game(
                R.drawable.texas_img,
                "Texas Stars",
                "Rockford IceHogs",
                R.drawable.rockford_img,
                "4 : 2",
                true
            )
        )

        //resultsState.value = data
    }

    fun onPrevMonthButtonClick() {
        setUpCalendar(-1)
    }

    fun onNextMonthButtonClick() {
        setUpCalendar(1)
    }

    fun onDayClick(position: Int) {
        dates.find {
            it.isSelected
        }?.let {
            it.isSelected = false
        }
        dates.getOrNull(position)?.let { date ->
            selectedDate = selectedDate.copy(day = date.dayOfTheMonth)
            date.isSelected = true
            updateDatesAction.call()
            when (selectedDate.day) {
                2 -> resultsTwoDayState.value = listTwo
                1 -> resultsOneDayState.value = listOne
                3 -> resultsThreeDayState.value = listThree
                else -> resultsState.value = emptyList()
            }
        }
    }

    private fun setUpCalendar(deltaMonth: Int) {
        val monthSdf = SimpleDateFormat("MMMM yyyy", Locale.ENGLISH)
        val monthCalendar = Calendar.getInstance()
        monthCalendar.set(Calendar.DAY_OF_MONTH, selectedDate.day)
        monthCalendar.set(Calendar.MONTH, selectedDate.month)
        monthCalendar.set(Calendar.YEAR, selectedDate.year)
        monthCalendar.add(Calendar.MONTH, deltaMonth)
        val maxDaysInMonth = monthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        selectedDate = Date(
            day = monthCalendar[Calendar.DAY_OF_MONTH],
            month = monthCalendar[Calendar.MONTH],
            year = monthCalendar[Calendar.YEAR]
        )
        dates.clear()
        val sdf = SimpleDateFormat("EEE", Locale.ENGLISH)
        for (i in 1..maxDaysInMonth) {
            monthCalendar.set(Calendar.DAY_OF_MONTH, i)
            dates.add(
                HorizontalCalendarItem(
                    isSelected = selectedDate.day == i,
                    dayOfTheMonth = i,
                    dayOfTheWeek = sdf.format(monthCalendar.time)
                )
            )
        }
        monthCalendar.set(Calendar.DAY_OF_MONTH, selectedDate.day)

        val selectedDayPosition = selectedDate.day - 1
        scrollDayPosition = when {
            selectedDayPosition > 2 -> selectedDayPosition - 3
            maxDaysInMonth - selectedDayPosition < 2 -> selectedDayPosition
            else -> selectedDayPosition
        }

        monthTitleState.value = monthSdf.format(monthCalendar.time)
        updateDatesAction.call()
        scrollDatesToPositionAction.value = scrollDayPosition
        //updateHabitList()
    }

    /*private fun updateHabitList() {
        habitsSubjectDisposable?.dispose()

        habitsSubjectDisposable =
            habitListSharedUseCase
                .habitsSubject(selectedDate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { habitListState.value = it }
                .also { disposables.add(it) }
    }*/

}