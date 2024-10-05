package com.qoollo

import com.qoollo.plugins.*
import com.qoollo.route.model.UserRouteModel
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlin.test.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }

        val response = client.post("/users") {
            contentType(ContentType.Application.Json)
            setBody(
                UserRouteModel(
                    login = "login",
                    password = "password",
                    firstName = "a",
                    secondName = "b"
                )
            )
        }
        println(response.bodyAsText())
    }
}
