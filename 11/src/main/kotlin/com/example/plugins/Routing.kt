package com.example.plugins

import com.example.config.JwtConfig
import com.example.config.MongoConfig
import com.example.model.schema.User
import com.example.model.schema.UserSource
import com.example.model.schema.UserSourceImpl
import com.example.model.schema.user
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import org.litote.kmongo.coroutine.CoroutineCollection


fun Application.configureModule() {
    val userCollection: CoroutineCollection<User> = MongoConfig.getDatabase().getCollection()
    val userSource: UserSource = UserSourceImpl(userCollection)

    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    install(Resources)
    JwtConfig
    install(Authentication) {
        jwt {
            verifier(JwtConfig.verifier)
            realm = "ktor.io"
            validate {
                it.payload.getClaim("id").asInt()?.let(userSource::findUserById)
            }
        }
    }

    routing {
        /**
         * A public login [Route] used to obtain JWTs
         */
        post("login") {
            val loginData = call.receive<LoginData>()
            val credentials = UserPasswordCredential(loginData.username, loginData.password)
            val user = userSource.findUserByCredentials(credentials)
            val token = JwtConfig.makeToken(user)
            call.respondText(token)
        }
        /**
         * All [Route]s in the authentication block are secured.
         */
        authenticate {
            route("secret") {

                get {
                    val user = call.user!!
                    call.respond(user)
                }
            }
            authenticate {
                route("/users") {
                    post("add-user") {
                        val newUser = call.receive<User>()
                        userSource.addUser(newUser)
                        call.respond(HttpStatusCode.Created)
                    }
                    post("add-multiple") {
                        val users = call.receive<List<User>>()
                        userSource.addUsers(users)
                        call.respond(HttpStatusCode.Created)
                    }
                    put("update/{id}") {
                        val userId = call.parameters["id"]?.toIntOrNull()
                        if (userId!=null) {
                            val updatedUser = call.receive<User>()
                            updatedUser.id = userId // Ensure the user id matches the path parameter
                            userSource.findOneAndUpdate(userId, updatedUser)
                            call.respond(HttpStatusCode.OK)
                        } else {
                            call.respond(HttpStatusCode.BadRequest, "Invalid user id")
                        }
                    }
                    delete("delete/{id}") {
                        val id = call.parameters["id"]?.toIntOrNull()
                        if (id!=null) {
                            userSource.deleteOneUser(id)
                            call.respond(HttpStatusCode.OK)
                        } else {
                            call.respond(HttpStatusCode.BadRequest, "Invalid user id")
                        }
                    }
                    get("/getUser/{id}") {
                        val id = call.parameters["id"]?.toIntOrNull()
                        if (id!=null) {
                            val user = userSource.getUser(id)
                            if (user!=null) {
                                call.respond(user)
                            } else {
                                call.respond(HttpStatusCode.NotFound)
                            }
                        } else {
                            call.respond(HttpStatusCode.BadRequest, "Invalid user id")
                        }
                    }
                    get("/getAllUsers") {
                        try {
                            val allUsers = userSource.getAllUsers().toList()
                            call.respond(allUsers)
                        } catch (e: Exception) {
                            call.respondText("Failed to retrieve users", status = HttpStatusCode.InternalServerError)
                        }
                    }
                    get("/getUsersByPagination") {
                        try {
                            val page = call.request.queryParameters["page"]?.toIntOrNull() ?: 1
                            val pageSize = call.request.queryParameters["pageSize"]?.toIntOrNull() ?: 10
                            val allUsers = userSource.getUsersByPagination(page, pageSize)
                            call.respond(allUsers)
                        } catch (e: Exception) {
                            call.respondText("Failed to retrieve users", status = HttpStatusCode.InternalServerError)
                        }
                    }
                    delete("/delete-duplicates") {
                        val deletedCount =  userSource.deleteDuplicateUsers()
                        if (deletedCount==-1) {
                            call.respondText(
                                "Failed to delete duplicate users",
                                status = HttpStatusCode.InternalServerError
                            )
                        } else {
                            call.respondText("Deleted $deletedCount duplicate users")
                        }
                    }
                }
            }
        }
    /**
         * Routes with optional authentication
         */
        authenticate(optional = true) {
            get("optional") {
                val user = call.user
                val response = if (user!=null) "authenticated!" else "optional"
                call.respond(response)
            }
        }
    }
}

/*
@Serializable
@Resource("/articles")
class Articles(val sort: String? = "new")
*/


@Serializable
data class LoginData(val username: String, val password: String)

//@Serializable
//data class AddUser(val username: String, val password: String)
/* Add other user data fields as needed */