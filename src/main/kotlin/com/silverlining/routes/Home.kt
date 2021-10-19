package com.silverlining.routes
import com.silverlining.repository.InMemoryLocationRepository
import com.silverlining.repository.LocationRepository
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.homeRoutes(){

    val locationRepo: LocationRepository = InMemoryLocationRepository()

    routing {
        // Landing page routing - get url
        get("/"){
            call.respond(FreeMarkerContent("home.ftl", null))
        }

        // TEST ROUTE
        get("/location"){
            // test call for the interphase
            call.respond(locationRepo.getAllLocationData())
        }

    }

}

