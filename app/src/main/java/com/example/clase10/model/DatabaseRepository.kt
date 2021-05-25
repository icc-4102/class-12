package com.example.clase10.model

import android.app.Application
import androidx.room.Room

class DatabaseRepository(application: Application) {
    private val database = Room.databaseBuilder(application, AppDatabase::class.java,"covid-case").build()

    fun getCovidCaseDao(): CovidCasesDao{
        return database.covidCaseDao()
    }


}