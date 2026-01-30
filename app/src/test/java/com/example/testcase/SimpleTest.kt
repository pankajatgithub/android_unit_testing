package com.example.testcase

import org.junit.Assert.assertEquals
import org.junit.Test

class SimpleTest {
    @Test
    fun sanityCheck() {
        assertEquals(2, 1 + 1)
    }
}