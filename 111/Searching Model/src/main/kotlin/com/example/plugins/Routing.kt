package com.example.plugins

import com.example.route.configureSearchRoute
import io.ktor.server.application.Application

fun Application.configureRouting() {
    configureSearchRoute()
}
