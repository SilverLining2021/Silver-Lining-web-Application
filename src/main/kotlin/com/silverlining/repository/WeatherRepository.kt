package com.silverlining.repository

import com.silverlining.entities.weatherDataClass

interface WeatherRepository {

    fun getAllWeatherData(): List<weatherDataClass>

}