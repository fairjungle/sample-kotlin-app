package com.example.plugins

import com.example.networkPayloads.SamplePostBody
import com.example.networkPayloads.SamplePostResponse
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        post("/postSample") {
            val requestBody = call.receive<SamplePostBody>()
            val responseBody = SamplePostResponse(
                stringValue = requestBody.attribute1,
                numberValue = requestBody.attribute2,
                message = "${requestBody.attribute1}:${requestBody.attribute2}"
            )
            call.respond(responseBody)
        }
    }
    routing {

    }
}
