package com.example.dbconfig

import org.litote.kmongo.coroutine.CoroutineDatabase

object MongoDBConfigFactory {
    private val mongoClient = MongoConfig(
        Configuration.env.dbName,
        Configuration.env.dbURL
    )

    fun getDatabase(): CoroutineDatabase {
        return mongoClient.getDatabase()
    }
}