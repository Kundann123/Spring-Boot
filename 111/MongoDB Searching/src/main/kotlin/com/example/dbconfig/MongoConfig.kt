package com.example.dbconfig

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.connection.ConnectionPoolSettings
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory.MAXSIZE
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory.MINSIZE
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

class MongoConfig(databaseName: String, databaseURL: String) {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    private var client: CoroutineClient
    private var database: CoroutineDatabase

    init {
        log.info("Loading Mongo Config...")
        client = KMongo.createClient(
            MongoClientSettings.builder()
                .applyConnectionString(ConnectionString(databaseURL))
                .applyToConnectionPoolSettings {
                    val idleTime = 0
                    ConnectionPoolSettings.builder().maxConnectionIdleTime(idleTime.toLong(), TimeUnit.MILLISECONDS)
                        .minSize(MINSIZE.toInt()).maxSize(MAXSIZE.toInt())
                }
                .applicationName("SearchingModelWithMongoDB")
                .build()
        ).coroutine
        database = client.getDatabase(databaseName)
    }

    fun getDatabase(): CoroutineDatabase {
        return database
    }
}
