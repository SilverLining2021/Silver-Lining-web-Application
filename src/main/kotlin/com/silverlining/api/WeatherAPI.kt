package com.silverlining.api

import okhttp3.*
import java.io.IOException

var coord: String = """{"coord":{"lon":-0.1257,"lat":51.5085},"weather":[{"id":804,"main":"Clouds","description":
    |"overcast clouds","icon":"04d"}],"base":"stations","main":{"temp":52,"feels_like":50.52,"temp_min":50.18,
    |"temp_max":53.35,"pressure":1021,"humidity":77},"visibility":10000,"wind":{"speed":5.75,"deg":230},"clouds":
    |{"all":90},"dt":1637076065,"sys":{"type":2,"id":2019646,"country":"GB","sunrise":1637047231,"sunset":1637079020},
    |"timezone":0,"id":2643743,"name":"London","cod":200}""".trimMargin()

var coordParam = """{"coord":{"lon":-0.1257,"lat":51.5085},"weather":[{"id":804,"main":"Clouds","description":
    |"overcast clouds","icon":"04d"}],"base":"stations","main":{"temp":52,"feels_like":50.52,"temp_min":50.18,
    |"temp_max":53.35,"pressure":1021,"humidity":77},"visibility":10000,"wind":{"speed":5.75,"deg":230},"clouds"
    |:{"all":90},"dt":1637076065,"sys":{"type":2,"id":2019646,"country":"GB","sunrise":1637047231,"sunset":1637079020}
    |,"timezone":0,"id":2643743,"name":"London","cod":200}""".trimMargin()

fun computeWeatherData() {
    val url = "https://community-open-weather-map.p.rapidapi.com/weather?q=London%2Cuk&lat=0&lon=0&id=2172797&lang=null&units=imperial&mode=json"
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

            if (body != null) {
                coord = body
            }

            // println("global json: $coord")

        }

    })

}

fun returnWeather(): String {
    computeWeatherData()
    return coord
}


public fun computeWeatherDataParam(latitude: Double, longitude: Double){

    val url = "https://community-open-weather-map.p.rapidapi.com/weather?lat=$latitude&lon=$longitude&mode=json"
    val requestParam = Request.Builder()
        .url(url)
        .get()
        .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
        .addHeader("x-rapidapi-key", "aa43a90cedmsh31aa780e7acce65p1991f9jsn3c1809540d9c")
        .build()

    val client = OkHttpClient()

    client.newCall(requestParam).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            println("failed to execute request")
        }

        override fun onResponse(call: Call, response: Response) {
            val body = response.body?.string()
            println(body)

            if (body != null) {
                coordParam = body
            }

            // println("global json: $coord")

        }

    })
}

fun returnWeatherParam(latitude: Double, longitude: Double): String {
    computeWeatherDataParam(latitude, longitude)
    return coordParam
}