package com.silverlining.routes
import com.silverlining.UserSession
import com.silverlining.plugins.DB.db
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.select

fun Application.loginRoutes() {
    routing {
        get("/login") {
            call.respond(FreeMarkerContent("login.ftl", null))
        }

        authenticate("auth-form") {
            post("/login") {
                val identity = call.principal<UserSession>();
                if (identity != null) {
                    log.debug("User ${identity?.name} logging in...")
                    call.sessions.set(UserSession(identity?.uid, name=identity?.name))
                }

                call.respondRedirect("/")
            }
        }

    }
}

