package com.silverlining.repository

import com.silverlining.entities.Location

interface LocationRepository {

    fun getAllLocationData(): Location

    fun initGeoLocation(latitude: Double, longitude: Double): Location

    fun getLongitude(): Double

    fun getLatitude(): Double

    fun postGeoLocation(latitude: Double, longitude: Double)

}