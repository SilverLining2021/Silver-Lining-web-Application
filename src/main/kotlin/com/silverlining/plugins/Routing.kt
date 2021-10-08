package com.silverlining.plugins
import com.silverlining.User
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.response.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.request.*


fun Application.configureRouting() {

    // Installed packages
    install(ContentNegotiation){
        jackson()
    }

    routing {

        // Landing page routing - get url
        get("/"){
            call.respondText("Hello world!")

            // API test
            //call.respond(User(1,"Luciano", "password"))
        }

        // Landing page routing - post url
        post("/"){
            val user = call.receive<User>()
            call.respond(user)
        }

        // About us page routing url
        get("/about-us"){
            call.respondText("About us!")
        }

        // Contact page routing url
        get("contact-us"){
            call.respondText("Contact us!")
        }
    }
}
