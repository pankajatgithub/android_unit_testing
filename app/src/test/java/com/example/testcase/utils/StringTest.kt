package com.example.testcase.utils

import junit.framework.TestCase.assertEquals
import kotlin.test.Test

class StringTest {
    @Test
    fun testStringReversal_EmptyString_expectedEmptyString() {
        val sut = Utils()
        val result = sut.reverseString("")
        assertEquals("", result)
    }

    @Test
    fun testStringReversal_SingleChar_expectedSingleChar() {
        val sut = Utils()
        val result = sut.reverseString("a")
        assertEquals("a", result)
    }

    @Test
    fun testStringReversal_ValidInput_expectedReverseString() {
        val sut = Utils()
        val result = sut.reverseString("abc")
        assertEquals("cba", result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReversal_NullInput_expectedException() {
        val sut = Utils()
        val result = sut.reverseString(null)
    }
}