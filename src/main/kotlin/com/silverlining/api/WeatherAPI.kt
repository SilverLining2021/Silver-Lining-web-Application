package com.silverlining.api

import okhttp3.*
import java.io.IOException

var coord = """{"coord":{"lon":-79.5167,"lat":8.9833},"weather":[{"id":803,"main":"Clouds",
    |"description":"broken clouds","icon":"04d"}],"base":"stations","main":{"temp":300.44,"feels_like":303.77,
    |"temp_min":298.75,"temp_max":302.08,"pressure":1008,"humidity":82},"visibility":10000,
    |"wind":{"speed":2.57,"deg":260},"clouds":{"all":75},"dt":1638385913,"sys":{"type":1,"id":7190,
    |"country":"PA","sunrise":1638357500,"sunset":1638399390},"timezone":-18000,"id":3703443,"name":"Panama City",
    |"cod":200}""".trimMargin()


fun computeWeatherDataParam(latitude: Double, longitude: Double){

    val url = "https://community-open-weather-map.p.rapidapi.com/weather?lat=$latitude&lon=$longitude&mode=json"
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

            println("global json: $coord")

        }

    })
}

fun returnWeather(latitude: Double, longitude: Double): String {
    computeWeatherDataParam(latitude, longitude)
    return coord
}