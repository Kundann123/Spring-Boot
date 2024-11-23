package com.example.config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.connection.ConnectionPoolSettings
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

object MongoConfig {
    private val log: Logger = LoggerFactory.getLogger(javaClass)
    private var client: CoroutineClient
    private var database: CoroutineDatabase
    private val prop = Configuration.env

    init {
        client = KMongo.createClient(
            MongoClientSettings.builder()
                .applyConnectionString(ConnectionString(prop.connectionString))
                .applyToConnectionPoolSettings {
                    ConnectionPoolSettings.builder().maxConnectionIdleTime(120000, TimeUnit.MILLISECONDS)
                        .minSize(5).maxSize(40)
                }
                .applicationName("Sample")
                .build()).coroutine
        database = client.getDatabase(prop.databaseName)
        log.info("Connected to MongoDB $database")
    }

    fun getDatabase(): CoroutineDatabase {
        log.info("creating DB $database")
        return database
    }
}





