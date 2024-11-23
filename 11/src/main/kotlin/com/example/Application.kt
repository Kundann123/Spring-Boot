package com.example

import com.example.config.Configuration
import com.example.plugins.configureHTTP
import com.example.plugins.configureModule
import com.example.plugins.configureMonitoring
import com.example.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    Configuration.initConfig(environment)
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    //configureRouting()
    configureModule()
    //configureDependencyInjection()
}


