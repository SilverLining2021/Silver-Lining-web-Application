package com.silverlining.routes
import com.silverlining.UserSession
import com.silverlining.repository.InMemoryWeatherRepository
import com.silverlining.repository.WeatherRepository
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*


fun Application.homeRoutes(){

    // val locationRepo: LocationRepository = InMemoryLocationRepository()
    val weatherRepo: WeatherRepository = InMemoryWeatherRepository()

    routing {
        // Landing page routing - get url
        get("/"){
            val session = call.sessions.get<UserSession>()
            call.respond(FreeMarkerContent("home.ftl", mapOf("user" to session)))
            routing {
                resources(staticBasePackage)
            }
        }


        get("/coords"){

            call.respond(weatherRepo.getAllWeatherDataParam(8.983333, -79.516670))

        }

    }
}







