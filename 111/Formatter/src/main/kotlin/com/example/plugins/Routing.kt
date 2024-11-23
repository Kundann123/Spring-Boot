package com.example.plugins

import com.example.route.configureFormatter
import io.ktor.server.application.Application

fun Application.configureRouting() {
    configureFormatter()
}
