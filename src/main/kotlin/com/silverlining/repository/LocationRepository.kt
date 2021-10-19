package com.silverlining.repository

import com.silverlining.entities.Location

interface LocationRepository {

    fun getAllLocationData(): List<Location>

    fun getGeoLocation(latitude: Double, longitude: Double): Location?

    fun postGeoLocation(latitude: Double, longitude: Double)

}