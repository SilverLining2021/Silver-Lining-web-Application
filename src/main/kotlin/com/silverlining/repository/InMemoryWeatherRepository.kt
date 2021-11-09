package com.silverlining.repository

import com.silverlining.api.getWeatherData
import com.silverlining.entities.WeatherData

class InMemoryWeatherRepository: WeatherRepository {

    override fun getAllWeatherData(): List<WeatherData> {
        TODO("not yet implemented")
    }
}