package com.silverlining.routes
import com.silverlining.UserSession
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*

fun Application.loginRoutes() {
    routing {
        get("/login") {
            call.respond(FreeMarkerContent("login.ftl", null))
        }

        authenticate("auth-form") {
            post("/login") {
                log.debug("User attempted login")
                val username = call.principal<UserIdPrincipal>()?.name.toString()

                // TODO: Query uid, username, & preferences from database
                call.sessions.set(UserSession(uid = 1, name = username, count = 1))

                call.respondRedirect("/")
            }
        }

    }
}

