package com.example

import com.example.networkPayloads.SamplePostBody
import com.example.networkPayloads.SamplePostResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*

fun ApplicationTestBuilder.sampleAppTestClient(): HttpClient {
    // load main module
    application {
        mainModule()
    }

    // create a test client
    val client = createClient {
        install(ContentNegotiation) {
            json()
        }
    }

    return client
}

class ApplicationTest {

    @Test
    fun basicTest() {
        assertEquals(1, 1)
    }

    @Test
    fun simpleGet() = testApplication {
        val client = sampleAppTestClient()

        //
        // Test a simple GET request
        //

        val getResponse = client.get("/")
        assertEquals(HttpStatusCode.OK, getResponse.status)
        assertEquals("Hello World!", getResponse.bodyAsText())
    }

    @Test
    fun simplePost() = testApplication {
        val client = sampleAppTestClient()

        //
        // Test a simple JSON-in JSON-out POST request.
        //

        val postResponse = client.post("/postSample") {
            contentType(ContentType.Application.Json)
            setBody(SamplePostBody("Age", 10))
        }
        val postResponseBody = postResponse.body<SamplePostResponse>()
        assertEquals(HttpStatusCode.OK, postResponse.status)
        assertEquals(postResponseBody.message, "Age:10")
    }
}