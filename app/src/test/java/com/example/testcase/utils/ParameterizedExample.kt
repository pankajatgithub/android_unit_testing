package com.example.testcase.utils

import junit.framework.TestCase.assertEquals
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.Test

@RunWith(value = Parameterized::class)
class ParameterizedExample(val input:String, val expectedValue:Boolean)
{
    @Test
    fun test(){
        val helper = Helper()
        val result = helper.isPallendrome(input)
        assertEquals(expectedValue,result)

    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is pallindrome - {1}")
        fun data():List<Array<Any>>{
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)

            )
        }
    }

}