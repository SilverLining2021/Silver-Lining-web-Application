package com.silverlining.repository

import com.silverlining.entities.weatherDataClass

interface WeatherRepository {

    fun getAllWeatherData(): List<weatherDataClass>

    fun getAllWeatherData(latitude: Double, longitude: Double): List<weatherDataClass>

}