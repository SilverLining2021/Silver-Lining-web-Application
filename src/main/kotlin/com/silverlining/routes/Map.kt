package com.silverlining.routes

import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*
import com.silverlining.repository.*

fun Application.mapRoutes(){

    val weatherRepo: WeatherRepository = InMemoryWeatherRepository()

    routing {
        // About us page routing url
        get("/map"){

            val weatherData = listOf(weatherRepo.getAllWeatherData())
            println(weatherData)
            call.respond(FreeMarkerContent("map.ftl", mapOf("data" to weatherData)))
        }
    }

}