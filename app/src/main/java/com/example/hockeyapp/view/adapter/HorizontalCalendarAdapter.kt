package com.example.hockeyapp.view.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.hockeyapp.R
import com.example.hockeyapp.databinding.DayItemBinding
import com.example.hockeyapp.model.HorizontalCalendarItem

class HorizontalCalendarAdapter (
    private val dates: List<HorizontalCalendarItem>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<HorizontalCalendarAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val binding = DayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = dates.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dates[position]
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: DayItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.calendarLinearLayout.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
        fun bind(item: HorizontalCalendarItem) {

            binding.tvDayOfTheWeek.text = item.dayOfTheWeek
            binding.tvDayOfTheMonth.text = item.dayOfTheMonth.toString()


            with(binding.calendarLinearLayout) {
                if (item.isSelected) {
                    background =
                        ContextCompat.getDrawable(itemView.context, R.drawable.day_item_background_enabled)
                    isEnabled = false
                } else {
                    background =
                        ContextCompat.getDrawable(itemView.context, R.drawable.day_item_background_disable)
                    isEnabled = true
                }
            }
        }
    }

}