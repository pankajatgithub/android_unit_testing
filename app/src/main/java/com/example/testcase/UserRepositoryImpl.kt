package com.example.testcase

class UserRepositoryImpl : UserRepository {

    private val users = listOf(
        User(1, "John","john@gmail.com","2assas1nq"),
        User(2, "Jane","jane@gmail.com","2assas1pq"),
        User(3, "Bob","bob@gmail.com","2assas12q"),
    )

    override fun loginUser(email: String, password: String): LOGIN_STATUS {
        val matched = users.filter { it.email == email }
        return if (matched.size == 1) {
            if (matched[0].password == password)
                LOGIN_STATUS.SUCCESS
            else
                LOGIN_STATUS.INVALID_PASSWORD
        } else {
            LOGIN_STATUS.INVALID_USER
        }
    }
}
