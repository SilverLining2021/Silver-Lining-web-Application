package com.silverlining.routes

import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.aboutusRoutes(){

    routing {
        // About us page routing url
        get("/about-us"){
            call.respond(FreeMarkerContent("aboutUs.ftl", null))
        }
    }

}