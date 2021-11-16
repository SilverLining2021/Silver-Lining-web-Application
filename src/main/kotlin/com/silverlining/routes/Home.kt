package com.silverlining.routes
import com.silverlining.UserSession
import com.silverlining.api.*
import com.silverlining.repository.InMemoryLocationRepository
import com.silverlining.repository.InMemoryWeatherRepository
import com.silverlining.repository.LocationRepository
import com.silverlining.repository.WeatherRepository
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*


fun Application.homeRoutes(){

    val locationRepo: LocationRepository = InMemoryLocationRepository()
    val weatherRepo: WeatherRepository = InMemoryWeatherRepository()

    routing {
        // Landing page routing - get url
        get("/"){
            val session = call.sessions.get<UserSession>()
            call.respond(FreeMarkerContent("home.ftl", mapOf("user" to session)))
        }

        // TEST ROUTE
        get("/location"){
            // test call for the interphase
            call.respond(locationRepo.getAllLocationData())

            // TODO("Build the location api post")
        }

        // Weather API ROUTE
        get("/weather"){
            // test call for the function
            //call.respond(getWeatherData())
            call.respond(weatherRepo.getAllWeatherData())

        }


    }
}







