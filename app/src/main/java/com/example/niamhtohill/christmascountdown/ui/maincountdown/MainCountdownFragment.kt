package com.example.niamhtohill.christmascountdown.ui.maincountdown

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.niamhtohill.christmascountdown.CountdownDisplayFragment
import com.example.niamhtohill.christmascountdown.R
import kotlinx.android.synthetic.main.main_countdown_fragment.*

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
        deer_animation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {}
            override fun onAnimationCancel(p0: Animator?) {}
            override fun onAnimationStart(p0: Animator?) {}
            override fun onAnimationEnd(p0: Animator?) {
                fragmentManager!!.beginTransaction().replace(R.id.container, CountdownDisplayFragment.newInstance()).commit()
            }
        })
    }
}
