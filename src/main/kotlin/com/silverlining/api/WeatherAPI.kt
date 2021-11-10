package com.silverlining.api

import com.google.gson.Gson
import com.silverlining.entities.WeatherData
import okhttp3.*
import java.io.IOException

fun getWeatherData() {
    val url = "https://community-open-weather-map.p.rapidapi.com/weather?q=London%2Cuk&lat=0&lon=0&callback=test&id=2172797&lang=null&units=imperial&mode=json"
    val request = Request.Builder()
        .url(url)
        .get()
        .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
        .addHeader("x-rapidapi-key", "aa43a90cedmsh31aa780e7acce65p1991f9jsn3c1809540d9c")
        .build()

    val client = OkHttpClient()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            println("failed to execute request")
        }

        override fun onResponse(call: Call, response: Response) {
            val body = response.body?.string()
            println(body)

            // TODO("Finish the data transmission to the data class WeatherData.kt")

            //val gson = Gson()
            //val weatherJson = gson.fromJson(body, WeatherData::class.java)
            //println(weatherJson)
        }

    })

}