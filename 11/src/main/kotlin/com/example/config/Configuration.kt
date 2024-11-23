package com.example.config

import com.example.model.dto.Configurations
import io.ktor.server.application.*

object Configuration {
    lateinit var env: Configurations

    fun initConfig(environment: ApplicationEnvironment){
        env = Configurations(
            connectionString = environment.config.property("ktor.database.connectionString").getString(),
            databaseName = environment.config.property("ktor.database.databaseName").getString()
        )
    }
}
