package com.example.clase10.model

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [CovidCaseEntity::class], version= 1, exportSchema = false)

abstract class AppDatabase: RoomDatabase() {
    abstract fun covidCaseDao(): CovidCasesDao
}