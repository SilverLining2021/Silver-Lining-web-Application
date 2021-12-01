package com.silverlining.repository

import com.google.gson.GsonBuilder
import com.silverlining.entities.weatherDataClass
import com.silverlining.api.*

class InMemoryWeatherRepository: WeatherRepository {

    override fun getAllWeatherDataParam(latitude: Double, longitude: Double): weatherDataClass {
        val coordinates: String = returnWeather(latitude,longitude)
        val gson = GsonBuilder().create()
        val weatherJson = gson.fromJson(coordinates, weatherDataClass::class.java)
        return (weatherJson)
    }

}