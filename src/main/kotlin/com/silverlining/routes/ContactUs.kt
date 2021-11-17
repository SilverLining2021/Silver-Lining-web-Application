package com.silverlining.routes
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.contactusRoutes(){

    routing {
        // Contact page routing url
        get("contact-us"){
            call.respond(FreeMarkerContent("contactUs.ftl", null))
            routing {
                resources(staticBasePackage)
            }

        }
    }

}