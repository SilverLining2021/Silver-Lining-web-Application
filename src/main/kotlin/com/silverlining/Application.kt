package com.silverlining
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.silverlining.plugins.*
import com.silverlining.routes.*


// Data structure to hold users
data class User(val id: Int? = null, val name: String, val password: String)


fun main()
{
    embeddedServer(Netty,
                   watchPaths = listOf("ktor-development"),
                   port = 8080,
                   host = "127.0.0.1")
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
