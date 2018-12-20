package com.example.niamhtohill.christmascountdown

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.countdown_display_fragment.*

class CountdownDisplayFragment : Fragment() {

    companion object {
        fun newInstance() = CountdownDisplayFragment()
    }

    private lateinit var viewModel: CountdownViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(CountdownViewModel::class.java)

        viewModel.fetchTime()

        viewModel.daysLeft.observe(this, Observer {
            days_textview.text = viewModel.daysLeft.value
        })
        viewModel.hoursLeft.observe(this, Observer {
            hours_textview.text = viewModel.hoursLeft.value
        })
        viewModel.minutesLeft.observe(this, Observer {
            minutes_textview.text = viewModel.minutesLeft.value
        })
        viewModel.secondsLeft.observe(this, Observer {
            seconds_textview.text = viewModel.secondsLeft.value
        })
        return inflater.inflate(R.layout.countdown_display_fragment, container, false)
    }
}