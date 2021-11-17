package com.silverlining.plugins
import com.silverlining.UserSession
import freemarker.cache.ClassTemplateLoader
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.content.*
import io.ktor.freemarker.*
import io.ktor.gson.*
import io.ktor.sessions.*


fun Application.configureInstalls() {
    // Installed packages
    install(ContentNegotiation){
        gson {
            setPrettyPrinting()
        }
    }

    // Free marker from Apache
    // https://ktor.io/docs/freemarker.html
    install(FreeMarker){
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    val MONTH = 86400L * 30L
    install(Sessions) {
        cookie<UserSession>("user_session") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = MONTH
        }
    }

    // This feature writes the logs to the server
    // io.ktor.features
    install(CallLogging)

    /*** Static resources routing ***/
    routing {

        //Static files definition
        static("/static") {
            resources("files")
        }
    }


}
