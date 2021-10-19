package com.silverlining.plugins
import freemarker.cache.ClassTemplateLoader
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.content.*
import io.ktor.freemarker.*
import io.ktor.gson.*


fun Application.configureInstalls() {

    /*** Installed packages ***/

    // Gson Library from Google
    // https://ktor.io/docs/gson.html#register_gson_converter

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