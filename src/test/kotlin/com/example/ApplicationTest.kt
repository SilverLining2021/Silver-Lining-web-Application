package com.example

import io.ktor.routing.*
import io.ktor.auth.*
import io.ktor.util.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*
import com.example.plugins.*

class ApplicationTest {
    @Test
    fun testRoot()
    {
        withTestApplication({ configureRouting() })
        {
            handleRequest(HttpMethod.Get, "/").apply{
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Goodbye  World!", response.content)
            }
        }
    }
}
