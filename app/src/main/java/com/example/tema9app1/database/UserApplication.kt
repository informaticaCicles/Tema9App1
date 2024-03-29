package com.example.tema9app1.database

import android.app.Application
import androidx.room.Room

class UserApplication : Application() {

    companion object{
        lateinit var database: UserDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this,
            UserDatabase::class.java,
            "UserDatabase")
            .build()
    }
}