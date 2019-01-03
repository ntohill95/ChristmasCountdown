package com.example.niamhtohill.christmascountdown

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class CountdownViewModel : ViewModel() {

    var daysLeft = MutableLiveData<String>().apply { postValue("0 days") }
    var hoursLeft = MutableLiveData<String>().apply { postValue("0 hours") }
    var minutesLeft = MutableLiveData<String>().apply { postValue("0 minutes") }
    var secondsLeft = MutableLiveData<String>().apply { postValue("0 seconds") }

    fun fetchTime() {
        val formatter = SimpleDateFormat("dd.MM.yyyy, HH:mm:ss")
        formatter.isLenient = false

        val endTime = "25.12." + Calendar.getInstance().get(Calendar.YEAR) + ", 00:00:00"
        lateinit var endDate: Date
        var milliseconds = 0L

        println("*******************" + endTime)
        try {
            endDate = formatter.parse(endTime)
            milliseconds = endDate.time
        } catch (e: ParseException) {
            println(e.message)
        }
        var startTime = System.currentTimeMillis()

        val countDownTimer = object : CountDownTimer(milliseconds, 1000) {
            override fun onTick(p0: Long) {
                startTime -= 1
                val serverUpTimeSeconds = (p0 - startTime) / 1000
                daysLeft.postValue((String.format("%d", serverUpTimeSeconds / 86400)) + " days")
                hoursLeft.postValue((String.format("%d", (serverUpTimeSeconds % 86400) / 3600)) + " hours")
                minutesLeft.postValue((String.format("%d", (((serverUpTimeSeconds % 86400) % 3600) / 60))) + " minutes")
                secondsLeft.postValue((String.format("%d", (((serverUpTimeSeconds % 86400) % 3600) % 60))) + " seconds")
            }

            override fun onFinish() {
            }
        }
        countDownTimer.start()
    }
}