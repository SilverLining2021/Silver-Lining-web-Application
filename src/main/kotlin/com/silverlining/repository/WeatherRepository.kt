package com.silverlining.repository

import com.silverlining.entities.weatherDataClass

interface WeatherRepository {

    fun getAllWeatherDataParam(latitude: Double, longitude: Double): weatherDataClass

}