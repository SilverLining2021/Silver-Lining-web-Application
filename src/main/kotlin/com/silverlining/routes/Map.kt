package com.silverlining.routes

import com.silverlining.api.computeWeatherDataParam
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*
import com.silverlining.repository.*
import io.ktor.http.content.*

fun Application.mapRoutes(){

    val weatherRepo: WeatherRepository = InMemoryWeatherRepository()

    routing {
        // About us page routing url
        get("/map"){

            routing {
                resources(staticBasePackage)
            }
            if(call.request.queryParameters.contains("lat") && call.request.queryParameters.contains("lng")){
                val lat = call.request.queryParameters["lat"]
                val lng = call.request.queryParameters["lng"]
                val response = computeWeatherDataParam(lat!!.toDouble(), lng!!.toDouble())
                call.respond(response)
                return@get
            }
            val weatherData = listOf(weatherRepo.getAllWeatherData())
            // println(weatherData)
            call.respond(FreeMarkerContent("map.ftl", mapOf("data" to weatherData)))
        }
    }

}