package com.example.testcase




import org.junit.Assert.assertEquals
import org.junit.Test


import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

//16:10 done
class UserServiceTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun testUserService_success() {
        whenever(userRepository.loginUser("email", "password"))
            .thenReturn(LOGIN_STATUS.SUCCESS)

        val sut = UserService(userRepository)

        val result = sut.loginUser("email", "password")

        assertEquals("Success", result)
    }

}