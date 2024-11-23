package com.example.repository

import com.example.config.MongoConfig
import com.example.model.schema.User
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.json
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class UserRepository {
    private val userCollection: CoroutineCollection<User> = MongoConfig.getDatabase().getCollection()
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    suspend fun saveUser(user: User) {
        try {
            log.info("User repository: ${user.json}")
            userCollection.save(user)
            log.info("Added user: ${user.json}")
        } catch (e: Exception) {
            log.info("exception repo: ${e.message}")
        }
    }
}

