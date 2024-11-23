package example.com.repository

import example.com.config.dbconfig.MongoConfigFactory
import example.com.model.UserResponseDTO
import org.slf4j.LoggerFactory

class UsersRepository {
    private val log = LoggerFactory.getLogger(javaClass)
    private val userDetailsCollection =
        MongoConfigFactory.getDatabase().getCollection<UserResponseDTO>("user_details")

    suspend fun getUserData(): UserResponseDTO? {
        return userDetailsCollection.findOne()
    }

    suspend fun saveUsersDetails(userResponseDTO: UserResponseDTO) {
        userDetailsCollection.insertOne(userResponseDTO)
    }

    suspend fun getUserDetails(id: String): UserResponseDTO {
        log.info("Fetching response from DB --> $id")
        val userId = id.toInt()
        return UserResponseDTO(
            userDetailsCollection.findOne()?.userResponse?.filter {
                it.id == userId
            } ?: emptyList(),
            userDetailsCollection.findOne()?.postResponse?.filter {
                it.id == userId
            } ?: emptyList(),
            userDetailsCollection.findOne()?.commentsResponse?.filter {
                it.id == userId
            } ?: emptyList()
        )
    }
}
