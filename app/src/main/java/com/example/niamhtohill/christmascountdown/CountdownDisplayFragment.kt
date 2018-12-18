package com.example.niamhtohill.christmascountdown

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.niamhtohill.christmascountdown.ui.maincountdown.MainCountdownViewModel

class CountdownDisplayFragment : Fragment() {

    companion object {
        fun newInstance() = CountdownDisplayFragment()
    }

    private lateinit var viewModel: MainCountdownViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.countdown_display_fragment, container, false)
    }
}