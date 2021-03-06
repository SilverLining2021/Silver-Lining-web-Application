package com.silverlining

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import io.ktor.util.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import kotlin.test.*
import io.ktor.server.testing.*
import com.silverlining.plugins.*
import com.silverlining.routes.setupRoutes

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ setupRoutes() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }
}