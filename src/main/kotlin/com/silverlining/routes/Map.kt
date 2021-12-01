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
                //var locationData =  locationRepo.getGeoLocation(lat!!.toDouble(), lng!!.toDouble())
                // val response = computeWeatherDataParam(lat!!.toDouble(), lng!!.toDouble())
                //println(response)
                //call.respond(response)
                return@get
            }

            // TODO( FINISH THE API CALL )
            //val locationData = locationRepo.initGeoLocation(lat.toDouble(), lng.toDouble())
            //val weatherData = weatherRepo.getAllWeatherDataParam(8.983333, -79.516670)
            //println(weatherData)
            call.respond(FreeMarkerContent("map.ftl", null))

        }
    }

}