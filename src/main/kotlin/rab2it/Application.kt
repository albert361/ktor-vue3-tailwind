package rab2it

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import rab2it.plugins.configureHTTP
import rab2it.plugins.configureMonitoring
import rab2it.plugins.configureRouting
import rab2it.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
    }.start(wait = true)
}
