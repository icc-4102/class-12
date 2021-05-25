package com.example.clase10.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CovidCaseModel (
    val updated: Long?,
    val country: String,
    val countryInfo: CountryInfo,
    val cases: Long,
    val todayCases: Long,
    val deaths: Long,
    val todayDeaths: Long?,
    val recovered: Long,
    val active: Long,
): Parcelable


@Parcelize
data class CountryInfo(
    val flag: String
): Parcelable
