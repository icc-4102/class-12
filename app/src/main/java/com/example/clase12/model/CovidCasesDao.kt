package com.example.clase10.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CovidCasesDao {
    @Query("SELECT * FROM caseTable")
    fun getAllCases(): List<CovidCaseEntity>

    @Query("SELECT * FROM caseTable WHERE country = :country")
    fun getCountry(country: String): CovidCaseEntity

    @Query("DELETE FROM caseTable WHERE country =:country")
    fun deleteCountry(country: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCase(case: CovidCaseEntity)
}