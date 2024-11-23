package com.example.model.schema

import io.ktor.server.application.*
import io.ktor.server.auth.*


val ApplicationCall.user get() = authentication.principal<User>()
val testUser = User("", 1, "", "", "", listOf("Yellow", "Red"))