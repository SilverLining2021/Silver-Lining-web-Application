package com.silverlining.routes

import com.silverlining.api.computeSportsData
import com.silverlining.entities.globalData
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*
import com.silverlining.repository.*
import io.ktor.http.content.*

fun Application.mapRoutes(){

    val weatherRepo: WeatherRepository = InMemoryWeatherRepository()
    val locationRepo: LocationRepository = InMemoryLocationRepository()

    //testing --
    val sportsRepo: SportsRepository = InMemorySportsRepository()

    var lat: Double = 0.0
    var lng: Double = 0.0

    routing {

        // About us page routing url
        get("/map") {

            routing {
                resources(staticBasePackage)
            }

            if (call.request.queryParameters.contains("lat") && call.request.queryParameters.contains("lng")) {
                val latitude = call.request.queryParameters["lat"]
                val longitude = call.request.queryParameters["lng"]

                //println(longitude.toString())
                //println(latitude.toString())

                if (latitude != null) {
                    lat = latitude.toDouble()
                }

                if (longitude != null) {
                    lng = longitude.toDouble()
                }

                // val locationData =  locationRepo.initGeoLocation(latitude!!.toDouble(), longitude!!.toDouble())
                // val weatherData = weatherRepo.getAllWeatherDataParam(locationData.latitude, locationData.longitude)

                // call.respond(FreeMarkerContent("map.ftl", mapOf("data" to weatherData)))

                return@get
            }

            val locationData =  locationRepo.initGeoLocation(lat, lng)
            val weatherData = weatherRepo.getAllWeatherDataParam(locationData.latitude, locationData.longitude)

            //val sportsData = computeSportsData(weatherData)
            val sportsData = computeSportsData(weatherData)
            val globalData = globalData(weatherData, sportsData)


            //else{
            //  val weatherData = weatherRepo.getAllWeatherDataParam(8.983333, -79.516670)
            call.respond(FreeMarkerContent("map.ftl", mapOf("data" to globalData)))

        }
    }
}