package com.silverlining.routes

import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*
import com.silverlining.repository.*
import io.ktor.http.content.*

fun Application.mapRoutes(){

    val weatherRepo: WeatherRepository = InMemoryWeatherRepository()
    val locationRepo: LocationRepository = InMemoryLocationRepository()

    routing {


        // About us page routing url
        get("/map") {

            routing {
                resources(staticBasePackage)
            }

            if (call.request.queryParameters.contains("lat") && call.request.queryParameters.contains("lng")) {
                val lat = call.request.queryParameters["lat"]
                val lng = call.request.queryParameters["lng"]

                println(lng.toString())
                println(lat.toString())
                val locationData =  locationRepo.initGeoLocation(lat!!.toDouble(), lng!!.toDouble())
                val weatherData = weatherRepo.getAllWeatherDataParam(locationData.latitude, locationData.longitude)

                call.respond(FreeMarkerContent("map.ftl", mapOf("data" to weatherData)))

                return@get
            }
            else{
                val weatherData = weatherRepo.getAllWeatherDataParam(8.983333, -79.516670)
                call.respond(FreeMarkerContent("map.ftl", mapOf("data" to weatherData)))
            }

        }
    }

}