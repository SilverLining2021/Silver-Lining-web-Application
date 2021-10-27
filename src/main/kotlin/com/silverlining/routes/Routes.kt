package com.silverlining.routes
import io.ktor.application.*

/**
 * Global installation method to install routing paths for the webapp.
 */

fun Application.setupRoutes() {
    homeRoutes()         //Home.kt -> home.ftl
    aboutusRoutes()      //AboutUs.kt -> aboutUs.ftl
    contactusRoutes()    //ContactUs.kt -> contactUs.ftl
    mapRoutes()          //Map.kt -> map.ftl
}