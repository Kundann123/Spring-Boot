package example.com.config.dbconfig

import example.com.config.dbconfig.MongoDBProps.mongoDBProps
import org.litote.kmongo.coroutine.CoroutineDatabase

object MongoConfigFactory {
    private val mongoClient = MongoConfig(mongoDBProps.databaseName, mongoDBProps.connectionString)
    fun getDatabase(): CoroutineDatabase {
        return mongoClient.getDatabase()
    }
}

data class MongoDBPropDTO(
    var connectionString: String = "",
    var databaseName: String = ""
)
