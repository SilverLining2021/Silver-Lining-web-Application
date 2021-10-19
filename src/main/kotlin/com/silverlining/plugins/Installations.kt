package com.silverlining.plugins
import freemarker.cache.ClassTemplateLoader
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.http.content.*
import io.ktor.freemarker.*


fun Application.configureInstalls() {

    // Installed packages
    install(ContentNegotiation){
        jackson()
    }
    install(FreeMarker){
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    routing {
        //Static files definition
        static("/static") {
            resources("files/static/")

        }
    }


}