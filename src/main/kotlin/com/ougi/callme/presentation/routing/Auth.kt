package com.ougi.callme.presentation.routing

import io.ktor.server.routing.*

fun Route.configureAuthRouting() {
    route("/auth") {
        login()
    }
}

private fun Route.login() = post("/login") {}.proceedRoute(AUTH_SERVICE_NAME)


private const val AUTH_SERVICE_NAME = "callme-auth"