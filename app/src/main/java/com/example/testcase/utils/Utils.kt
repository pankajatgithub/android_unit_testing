package com.example.testcase.utils

class Utils {
    fun validatePassword(input : String) = when{
        input.isBlank() -> {
            "Password is required field"
        }
        input.length < 6 -> {
            "Length of password should be greater than 6"

        }
        input.length > 15 -> {
            "Length of password should be less than 15"
        }
        else -> {
            "Password is valid"
        }
    }
}