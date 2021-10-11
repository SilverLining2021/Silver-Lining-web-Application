package com.silverlining.routes
import com.silverlining.User
import com.silverlining.plugins.*
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.aboutusRoutes(){

    routing {
        // About us page routing url
        get("/about-us"){
            val sampleUser = User(1, "user", "password")
            call.respond(FreeMarkerContent("aboutUs.ftl", mapOf("user" to sampleUser)))
        }
    }

}