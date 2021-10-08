package com.silverlining
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.silverlining.plugins.*
import io.ktor.application.*
import io.ktor.auth.Authentication.Feature.install
import io.ktor.features.*
import io.ktor.jackson.*
import org.ktorm.database.Database

// Data structure to hold users
data class User(val id: Int? = null, val name: String, val password: String)


fun main()
{
    embeddedServer(Netty,
                   watchPaths = listOf("ktor-development"),
                   port = 8080,
                   host = "0.0.0.0")
    {
        // configuration for routing in Routing.kt
        configureRouting()
        // configuration for security in Security.kt
        configureSecurity()
        // configuration fro database in Database.kt
        configurationDB()

    }.start(wait = true)
}
