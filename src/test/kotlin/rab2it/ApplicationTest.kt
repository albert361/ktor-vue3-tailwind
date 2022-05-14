package rab2it

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import rab2it.plugins.configureHTTP
import rab2it.plugins.configureMonitoring
import rab2it.plugins.configureRouting
import rab2it.plugins.configureSerialization
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
            configureHTTP()
            configureMonitoring()
            configureSerialization()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("{\"content\":\"hello world\"}", bodyAsText())
        }
    }
}