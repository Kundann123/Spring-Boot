package com.example.routes

import com.example.di.kodein
import com.example.dto.DropdownDTO
import com.example.service.SearchingService
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.routing
import io.ktor.server.routing.route
import io.ktor.server.routing.post
import org.kodein.di.instance

fun Application.configureDropdownRoute(){
    val searchingService by kodein.instance<SearchingService>()
    routing {
        route("/dropdown"){
            post("/check") {
                val body=call.receive<DropdownDTO>()
                call.respond(searchingService.search(body) as Any)
            }
        }
    }
}
