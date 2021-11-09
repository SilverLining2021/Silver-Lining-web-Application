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
