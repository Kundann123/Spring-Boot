package com.example.route

import com.example.di.kodein
import com.example.dto.InputDTO
import com.example.service.SearchService
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.routing
import io.ktor.server.routing.route
import io.ktor.server.routing.post
import org.kodein.di.instance

fun Application.configureSearchRoute() {
    val searchService by kodein.instance<SearchService>()
    routing {
        route("/transformation") {
            post("/check") {
                val body = call.receive<InputDTO>()
                call.respond(searchService.searching(body))
            }
        }
    }
}
