package com.silverlining.routes
import com.silverlining.UserSession
import com.silverlining.repository.InMemoryLocationRepository
import com.silverlining.repository.InMemoryWeatherRepository
import com.silverlining.repository.LocationRepository
import com.silverlining.repository.WeatherRepository
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.http.content.*
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
            routing {
                resources(staticBasePackage)
            }
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

        get("/coords"){
            call.respond(weatherRepo.getAllWeatherData(8.983333, -79.516670))
        }

        get("/test"){
            call.respond(FreeMarkerContent("test.ftl", null))
            routing {
                resources(staticBasePackage)
            }

        }


    }
}







