package com.example.niamhtohill.christmascountdown.ui.maincountdown

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.niamhtohill.christmascountdown.R

class MainCountdownFragment : Fragment() {

    companion object {
        fun newInstance() = MainCountdownFragment()
    }

    private lateinit var viewModel: MainCountdownViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_countdown_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainCountdownViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
