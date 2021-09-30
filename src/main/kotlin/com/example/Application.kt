package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

// TEST ROUTING
// using "get" method - parameter is the site directory
// a couple of tests here get to understand how this works 
fun Application.main(){
    routing{
        get("/"){
            call.respondText("Hello SilverLinings!")
        }
        get("/test1"){
            call.respondText("Test 1...")
        }
        get("/test2"){
            call.respondText("Test 2...")
        }
    }
}

fun main(){
    embeddedServer(Netty, port = 8080, host = "127.0.0.1"){
        install(Routing)
        main()
    }.start(wait = true)
}
