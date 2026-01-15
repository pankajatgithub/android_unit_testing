package com.example.testcase.utils

import junit.framework.TestCase.assertEquals
import org.junit.Test


class HelperTest {
    @Test
    fun isPallindrome(){
        val helper = Helper()
        val result = helper.isPallendrome("hello")
        assertEquals(false,result)
    }
    @Test
    fun isPallindrome_inputString_level_expectedTrue(){
        val helper = Helper()
        val result = helper.isPallendrome("level")
        assertEquals(true,result)

    }

}