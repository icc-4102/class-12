package com.example.clase10.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "caseTable")
data class CovidCaseEntity(
    @PrimaryKey
    @ColumnInfo(name = "country") var country: String,
    @ColumnInfo(name = "flag") var flag: String,
    @ColumnInfo(name = "cases") var cases: String,
    @ColumnInfo(name = "death") var death: String,
    @ColumnInfo(name = "todayCases") var todayCases: String,
    @ColumnInfo(name = "todayDeaths") var todayDeaths: String,
    @ColumnInfo(name = "recovered") var recovered: String,
    @ColumnInfo(name = "active") var active: String,
)
