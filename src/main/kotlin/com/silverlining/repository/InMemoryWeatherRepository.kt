package com.silverlining.repository

import com.google.gson.GsonBuilder
import com.silverlining.entities.weatherDataClass
import com.silverlining.api.*

class InMemoryWeatherRepository: WeatherRepository {

    override fun getAllWeatherData(): List<weatherDataClass> {
        val coordinates: String = returnWeather()
        val gson = GsonBuilder().create()
        val weatherJson = gson.fromJson(coordinates, weatherDataClass::class.java)
        val weather = listOf(weatherJson)
        return(weather)
    }

    override fun getAllWeatherData(latitude: Double, longitude: Double): List<weatherDataClass> {
        val coordinates: String = returnWeatherParam(latitude,longitude)
        val gson = GsonBuilder().create()
        val weatherJson = gson.fromJson(coordinates, weatherDataClass::class.java)
        val weather = listOf(weatherJson)
        return (weather)
    }

}