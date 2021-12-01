package com.silverlining.routes

import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.aboutusRoutes(){

    routing {
        // About us page routing url
        get("/about-us"){
            routing {
                resources(staticBasePackage)
            }
            call.respond(FreeMarkerContent("aboutUs.ftl", null))
        }
    }

}