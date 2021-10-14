package com.silverlining.plugins
import freemarker.cache.ClassTemplateLoader
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.http.content.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.sessions.*
import io.ktor.gson.*


fun Application.configureInstalls() {

    // Installed packages
    install(ContentNegotiation){
        gson(){
            setPrettyPrinting()
        }
    }

    // Free marker from Apache
    // https://ktor.io/docs/freemarker.html

    install(FreeMarker){
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    install(Sessions) {
        cookie<UserSession>("user_session") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 86400 * 30
        }
    }

    install(Authentication) {
        form("auth-form") {
            userParamName = "username"
            passwordParamName = "password"
            validate { credentials ->
                if (credentials.name == "myusername" && credentials.password == "hunter2") {
                    UserIdPrincipal(credentials.name)
                } else {
                    // failure to authenticate
                    null
                }

            }
        }
        session<UserSession> {
            validate {
                session -> session /* TODO: Unstub this */
            }
            challenge {
                call.respondRedirect("/login")
            }
        }
    }

    // This feature writes the logs to the server
    // io.ktor.features

    install(CallLogging)

    /*** Static resources routing ***/

    routing {

        //Static files definition
        static("/static") {
            resources("files/static/")

        }
    }


}
