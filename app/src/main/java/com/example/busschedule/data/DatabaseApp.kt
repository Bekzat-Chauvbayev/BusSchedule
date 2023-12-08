package com.example.busschedule.data

import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class DatabaseApp:RoomDatabase(){
    abstract fun busSchedule():ScheduleDao

    companion object{
        @Volatile
        private var INSTANCE: DatabaseApp?=null

        fun getDatabase(context: Context):DatabaseApp{
            return INSTANCE ?: synchronized(this){
                Room.databaseBuilder(context,DatabaseApp::class.java,"app_database").createFromAsset("database/bus_schedule.db").fallbackToDestructiveMigration().build().also { INSTANCE = it }
            }
        }
    }
}