package com.example.clase10

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CovidCase(
    val attributes: Attributes,
    val geometry: Geometry
): Parcelable

@Parcelize
data class Attributes(
    val Active: Int,
    val Confirmed: Int,
    val Country_Region: String,
    val Deaths: Int,
    val Lat: Double,
    val Long_: Double,
    val Recovered: Int
):Parcelable

@Parcelize
data class Geometry(
    val x: Double,
    val y: Double
):Parcelable

