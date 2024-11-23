package com.example.model.schema

import com.mongodb.client.result.UpdateResult
import io.ktor.server.auth.*
import org.litote.kmongo.combine
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineFindPublisher
import org.litote.kmongo.eq
import org.litote.kmongo.setValue
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class UserSourceImpl(

    override val userCollection: CoroutineCollection<User>) : UserSource {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun findUserById(id: Int): User = users.getValue(id)

    override fun findUserByCredentials(credential: UserPasswordCredential): User = testUser

    private val users = listOf(testUser).associateBy(User::id)

    override suspend fun addUser(user: User) {
        userCollection.insertOne(user)
    }

    override suspend fun addUsers(users: List<User>) {
        userCollection.insertMany(users)
    }

    override suspend fun findOneAndUpdate(id: Int, user: User): UpdateResult {
        val filter = User::id eq id // Filter by user ID
        val update = combine(
            setValue(User::name, user.name),
            setValue(User::gender, user.gender),
            setValue(User::state, user.state),
            setValue(User::colours, user.colours)
        )
        return userCollection.updateOne(filter, update)
    }

    override suspend fun deleteOneUser(id: Int) {
        val filter = User::id eq id
        userCollection.deleteOne(filter)
    }

    override suspend fun getUser(id: Int): User? {
        println("id..$id")
        return userCollection.findOne(User::id eq id)
    }

    override suspend fun getAllUsers(): CoroutineFindPublisher<User> {
        println("Fetching all users")
        return userCollection.find()
    }

    override suspend fun getUsersByPagination(page: Int, pageSize: Int): List<User> {
        println("Fetching users - page: $page, pageSize: $pageSize")
        val skip = (page - 1) * pageSize
        return userCollection.find().skip(skip).limit(pageSize).toList()
    }

    override suspend fun deleteDuplicateUsers(): Int {
        // Get all users from the collection
        val allUsers = userCollection.find().toList()

        // Initialize a set to store unique user IDs
        val uniqueIds = mutableSetOf<Int>()

        // Initialize a counter to keep track of deleted users
        var deletedCount = 0

        // Iterate through all users
        for (user in allUsers) {
            // Check if the user ID is unique
            if (!uniqueIds.contains(user.id)) {
                // If the ID is unique, add it to the set
                uniqueIds.add(user.id)
            } else {
                // If the ID is a duplicate, delete the user from the collection
                val deleteResult = userCollection.deleteOne(User::id eq user.id)
                if (deleteResult.wasAcknowledged()) {
                    deletedCount++
                }
            }
        }

        return deletedCount
    }
}




