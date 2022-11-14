package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::mainModule)
        .start(wait = true)
}

fun Application.mainModule() {
    install(ContentNegotiation) {
        json()
    }
    configureRouting()
}
