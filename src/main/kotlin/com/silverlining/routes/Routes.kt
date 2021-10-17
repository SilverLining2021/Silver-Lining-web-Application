package com.silverlining.routes
import com.silverlining.User
import com.silverlining.plugins.configureInstalls
import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

/**
 * Global installation method to install routing paths for the webapp.
 */
fun Application.setupRoutes() {
    homeRoutes()         //Home.kt -> home.ftl
    aboutusRoutes()      //AboutUs.kt -> aboutUs.ftl
    contactusRoutes()    //ContactUs.kt -> contactUs.ftl
    mapRoutes()          //Map.kt -> map.ftl
}