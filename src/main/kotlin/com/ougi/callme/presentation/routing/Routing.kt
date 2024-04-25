package com.ougi.callme.presentation.routing

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() =
    routing {
        route("/open") {
            configureAuthRouting()
        }
    }

fun Route.proceedRoute(targetServiceName: String) {
    val client by inject<HttpClient>()
    handle {
        client.request("http://$targetServiceName:8080/${call.request.uri}") {
            method = call.request.httpMethod
            headers.appendAll(call.request.headers)
            setBody(call.receiveText())
        }
            .let { response -> call.respond(response.status, response.readBytes()) }
    }
}