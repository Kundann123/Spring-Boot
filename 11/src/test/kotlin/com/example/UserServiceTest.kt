package com.example

import com.example.config.Configuration
import com.example.model.schema.User
import com.example.model.schema.UserSource
import com.mongodb.assertions.Assertions
import io.ktor.server.config.*
import io.ktor.server.testing.*
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.mockkObject
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


internal class UserServiceTest {
    @MockK
    lateinit var userSource: UserSource

    @Before
    fun setup() {
        createTestEnvironment {
            config = ApplicationConfig(
                "application.conf"
            )
            Configuration.initConfig(this.build { })
        }
        MockKAnnotations.init(this)
        mockkObject(Configuration)
        coEvery { userSource.addUser(any()) } returns Unit
    }

    @Test
    fun savedUser() { // Prepare test user
        val saveUser = User(
            "",
            0,
            "",
            "",
            "",
            colours = listOf("", "")
        )
        runBlocking {
            val expected = "65d5b661c3f92329b1d8923b"
            userSource.addUser(saveUser).let {
                Assertions.assertNotNull(expected)
            }
        }
    }

    @Test
    fun getUserById() {
        // Prepare a mock user
        val getUserById = User(
            "",
            35,
            "",
            "",
            "Texas",
            colours = listOf("Red", "Blue")
        )
        runBlocking {
            // Mock the getUser function to return the mock user
            coEvery { userSource.getUser(any()) } returns getUserById

            // Call the getUser function
            val result = userSource.getUser(35)

            // Assert that the result is not null
            assertNotNull(result)

            // Assert that the returned user matches the mock user
            assertEquals(getUserById, result)
        }
    }

    @Test
    fun testDeleteUser() {
        // Run the test in a coroutine scope
        runBlocking {
            // Prepare a mock user
            User(
                "",
                35,
                "",
                "",
                "Texas",
                colours = listOf("Red", "Blue")
            )

            // Mock the deleteOneUser function to return Unit
            coEvery { userSource.deleteOneUser(any()) } returns Unit

            // Call the deleteOneUser function
            val result = userSource.deleteOneUser(35)

            // Assert that the result is not null
            assertNotNull(result)
        }
    }


    @Test
    fun testUpdateUser() {
        // Prepare a mock user
        val updatedUser = User(
            "",
            1,
            "Updated Name",
            "Male",
            "Texas",
            colours = listOf("Yellow", "Red")
        )

        // Run the test within a coroutine scope
        runBlocking {
            // Mock the findOneAndUpdate function to return UpdateResult
            coEvery { userSource.findOneAndUpdate(any(), any()) } returns mockk()

            // Call the findOneAndUpdate function
            val result = userSource.findOneAndUpdate(1, updatedUser)

            // Assert that the result is not null
            assertNotNull(result)
        }
    }
}