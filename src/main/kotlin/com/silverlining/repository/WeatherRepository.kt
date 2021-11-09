package com.silverlining.repository

import com.silverlining.api.getWeatherData
import com.silverlining.entities.WeatherData

interface WeatherRepository {

    fun getAllWeatherData(): List<WeatherData>

}