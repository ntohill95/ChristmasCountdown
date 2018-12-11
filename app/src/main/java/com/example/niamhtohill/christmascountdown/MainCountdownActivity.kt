package com.example.niamhtohill.christmascountdown

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.niamhtohill.christmascountdown.ui.maincountdown.MainCountdownFragment

class MainCountdownActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_countdown_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainCountdownFragment.newInstance())
                .commitNow()
        }
    }
}
