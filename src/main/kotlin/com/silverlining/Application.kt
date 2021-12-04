package com.silverlining
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.silverlining.plugins.*
import com.silverlining.routes.*

fun main()
{
    embeddedServer(Netty,
                   watchPaths = listOf("ktor-development"),
                   port = 8080,
                   host = "0.0.0.0")
    {
        // configuration for routing in Installations.kt
        configureInstalls()
        // configuration for security in Security.kt
        configureSecurity()
        // configuration for database in Database.kt
        configurationDB()

        // Setup routing
        setupRoutes()

    }.start(wait = true)

}
