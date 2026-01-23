package com.example.testcase.utils

import junit.framework.TestCase.assertEquals
import kotlin.test.Test

class PasswordTest {

    @Test
    fun validatePassword_blankInput_expectedRequiredField() {
        val sut = Utils()
        val result = sut.validatePassword("    ")
        assertEquals("Password is required field", result)
    }

    @Test
    fun validatePassword_2CharInput_expectedValidationMsg() {
        val sut = Utils()
        val result = sut.validatePassword("ab")
        assertEquals("Length of password should be greater than 6", result)

    }

    @Test
    fun validatePassword_16CharInput_expectedValidationMsg() {
        val sut = Utils()
        val result = sut.validatePassword("abcdefghijklnmop")
        assertEquals("Length of password should be less than 15", result)
    }

    @Test
    fun validatePassword_ValidInput_expectedValidPassword() {
        val sut = Utils()
        val result = sut.validatePassword("abcdefgh")
        assertEquals("Password is valid", result)

    }

}