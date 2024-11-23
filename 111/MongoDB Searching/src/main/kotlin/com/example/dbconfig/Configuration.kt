package com.example.dbconfig

import io.ktor.server.application.ApplicationEnvironment

object Configuration {
    lateinit var env: ConfigParameters

    fun initConfig(environment: ApplicationEnvironment) {
        env = ConfigParameters(
            dbURL = environment.config.property("ktor.db.dbURL").getString(),
            dbName = environment.config.property("ktor.db.dbName").getString()
        )
    }
}
