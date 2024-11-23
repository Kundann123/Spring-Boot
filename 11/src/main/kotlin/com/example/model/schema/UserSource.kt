package com.example.model.schema

import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineFindPublisher
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger


interface UserSource {
    val userCollection: CoroutineCollection<User> // Abstract property declaration
    private val log: Logger
        get() = getLogger(this.javaClass)

    fun findUserById(id: Int): User

    fun findUserByCredentials(credential: io.ktor.server.auth.UserPasswordCredential): User

    suspend fun addUser(user: User)

    suspend fun addUsers(users: List<User>)

    suspend fun findOneAndUpdate(id: Int, user: User): Any

    suspend fun deleteOneUser(id: Int)

    suspend fun getUser(id: Int): User? {
        println("Fetching user with id: $id")
        return this.userCollection.findOne()
    }

    suspend fun getAllUsers(): CoroutineFindPublisher<User> {
        println("Fetching all users")
        return this.userCollection.find()
    }

    suspend fun getUsersByPagination(page: Int, pageSize: Int): List<User>

    suspend fun deleteDuplicateUsers(): Int
}

