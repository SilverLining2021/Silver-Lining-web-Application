package com.silverlining.entities

/**
 * Weather data class based on the api documentation and Json file
 * website: https://rapidapi.com/weatherapi/api/weatherapi-com/
 * website: https://www.weatherapi.com/docs/
 */

// Main class:

data class WeatherData(
    val coord: List<Coordinates>,
    val main: List<Main>,
    val visibility: Int,
    val wind: List<Wind>,
    val sys: List<Sys>,
    val timezone: Int,
    val id: Int,
    val name: String,
    val code: Int
)

// Sub classes:

data class Coordinates(
    val lon: Double,
    val lat: Double
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int
)

data class Wind(
    val speed: Double,
    val deg: Int
)

data class Sys(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Int
)
