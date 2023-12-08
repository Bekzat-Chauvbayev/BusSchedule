package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.DatabaseApp

class BusScheduleApplication:Application() {
    val database: DatabaseApp by lazy { DatabaseApp.getDatabase(this) }
}