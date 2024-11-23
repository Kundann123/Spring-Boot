package example.com

import example.com.config.dbconfig.MongoConfigFactory
import example.com.plugins.*
import io.ktor.server.application.Application

fun main(args: Array<String>): Unit =
    io.ktor.server.cio.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureDaprModule()
    configureDI()
    modifyApplicationEnvConfiguration()
    configureSerialization()
    configureRouting()
    configureStatusPages()
    MongoConfigFactory.getDatabase()
}
