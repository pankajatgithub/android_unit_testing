package com.example.testcase

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FlowDemoTest {
    @Before
    fun setUp() {
    }

    @Test
    fun getFlowTest() = runTest {
        val sut = FlowDemo()
        val result = sut.getFlow().toList()
        assertEquals(listOf(1, 2, 3), result)
    }

    @After
    fun tearDown() {
    }
}