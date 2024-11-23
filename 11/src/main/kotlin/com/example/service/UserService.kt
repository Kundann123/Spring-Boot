/*

package com.example.service

import com.example.model.schema.User
import com.example.repository.UserRepository
import org.koin.java.KoinJavaComponent
import org.litote.kmongo.json
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class UserService {
    private val userRepository by KoinJavaComponent.inject<UserRepository>(UserRepository::class.java)
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    suspend fun addUser(user: User): User {
        try {
            log.info("User Service: ${user.json}")
            userRepository.saveUser(user)
            return user
        } catch (e: Exception) {
            log.info("exception: ${e.message}")
        }
        return user
    }

}
*/
