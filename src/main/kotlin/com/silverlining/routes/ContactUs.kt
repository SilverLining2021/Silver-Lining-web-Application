package com.silverlining.routes
import com.silverlining.User
import com.silverlining.plugins.*
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.contactusRoutes(){

    routing {
        // Contact page routing url
        get("contact-us"){
            val sampleUser = User(1, "user", "password")
            call.respond(FreeMarkerContent("contacUs.ftl", mapOf("user" to sampleUser)))
        }
    }

}