package com.silverlining.routes
import com.silverlining.User
import com.silverlining.plugins.*
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.mapRoutes(){

    routing {
        // About us page routing url
        get("/map"){

            call.respond(FreeMarkerContent("map.ftl", null))
        }
    }

}