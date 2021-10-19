package com.silverlining.routes
import com.silverlining.User
import com.silverlining.plugins.configureInstalls
import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.homeRoutes(){

    routing {
        // Landing page routing - get url
        get("/"){
            call.respond(FreeMarkerContent("home.ftl", null))
        }

        // Landing page routing - post url
        post("/"){
            val user = call.receive<User>()
            call.respond(user)
        }
    }

}

