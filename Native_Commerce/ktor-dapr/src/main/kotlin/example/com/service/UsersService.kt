package example.com.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import example.com.config.getState
import example.com.config.setState
import example.com.model.UserResponseDTO
import example.com.model.UserDto
import example.com.model.PostDTO
import example.com.model.CommentsDTO
import example.com.plugins.ConfigureClient
import example.com.repository.UsersRepository
import example.com.util.getKoinInstance
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.slf4j.LoggerFactory

class UsersService {
    private val log = LoggerFactory.getLogger(javaClass)
    private val usersRepository = getKoinInstance<UsersRepository>()

    suspend fun getUserDetails(id: String?): UserResponseDTO {
        return if (id != null) {
            val redisResponse = id.getState() //retrieving state from redis
            redisResponse.fold(
                ifRight = { jacksonObjectMapper().convertValue(it, UserResponseDTO::class.java) },
                ifLeft = { usersRepository.getUserDetails(id) }
            )
        } else {
            val userResponse =
                ConfigureClient.client.get("https://jsonplaceholder.typicode.com/users").body<List<UserDto>>()

            val postResponse =
                ConfigureClient.client.get("https://jsonplaceholder.typicode.com/posts").body<List<PostDTO>>()

            val commentsResponse =
                ConfigureClient.client.get("https://jsonplaceholder.typicode.com/comments").body<List<CommentsDTO>>()

            commentsResponse.forEach { comment ->
                val userList = userResponse.filter { it.id == comment.id }
                val postList = postResponse.filter { it.id == comment.id }
                val commentsList = listOf(comment)
                val combinedResponse = UserResponseDTO(userList, postList, commentsList)
                comment.id.toString().setState(combinedResponse)  //saving the state in redis
            }

            UserResponseDTO(
                userResponse,
                postResponse,
                commentsResponse
            ).also {
                val check = usersRepository.getUserData()?.equals(it)
                if (check == false || check == null)
                    usersRepository.saveUsersDetails(it)
            }
        }
    }
}
