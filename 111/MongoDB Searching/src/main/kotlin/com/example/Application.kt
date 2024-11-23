package com.example

import com.example.dbconfig.Configuration
import com.example.dbconfig.MongoDBConfigFactory
import com.example.plugins.configureSerialization
import com.example.plugins.configureRouting
import com.example.plugins.configureStatusPages
import io.ktor.server.application.Application

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("Unused")
fun Application.module() {
    Configuration.initConfig(this.environment)
    configureSerialization()
    configureRouting()
    configureStatusPages()
    MongoDBConfigFactory.getDatabase()
}
