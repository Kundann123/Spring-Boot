package example.com.config

import example.com.config.dbconfig.MongoDBPropDTO
import example.com.util.getKoinInstance
import io.dapr.client.DaprClient
import io.dapr.exceptions.DaprException
import mu.KotlinLogging

val log = KotlinLogging.logger { }
fun getMongoDbSecrets(): MongoDBPropDTO {
    var dbUrl = ""
    var dbName = ""
    try {
        dbUrl =
            getKoinInstance<DaprClient>().getSecret("mongoDBVault", "connectionString").block()?.get("connectionString")
                .toString()
        dbName = getKoinInstance<DaprClient>().getSecret("mongoDBVault", "databaseName").block()?.get("databaseName")
            .toString()
    } catch (vaultError: DaprException) {
        log.error("Key vault error while fetching key: --> $vaultError")
    }
    println("Connection String === $dbUrl, Database Name === $dbName")
    return MongoDBPropDTO(
        dbUrl,
        dbName
    )
}
