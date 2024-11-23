package com.example.plugins

import com.example.routes.configureDropdownRoute
import io.ktor.server.application.Application

fun Application.configureRouting() {
    configureDropdownRoute()
}
