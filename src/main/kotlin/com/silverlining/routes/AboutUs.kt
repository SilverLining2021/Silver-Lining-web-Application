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
            call.respond(FreeMarkerContent("aboutUs.ftl", null))
        }
    }

}