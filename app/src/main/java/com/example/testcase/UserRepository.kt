package com.example.testcase

interface UserRepository {
    fun loginUser(email: String, password: String): LOGIN_STATUS


//    fun loginUser(email:String, password: String): LOGIN_STATUS {
//        val users = users.filter { user -> user.email == email}
//        return if(users.size == 1) {
//            if (users[0].password == password) {
//                LOGIN_STATUS.SUCCESS
//            } else {
//                LOGIN_STATUS.INVALID_PASSWORD
//            }
//
//        } else {
//            LOGIN_STATUS.INVALID_USER
//        }
//    }

    }


