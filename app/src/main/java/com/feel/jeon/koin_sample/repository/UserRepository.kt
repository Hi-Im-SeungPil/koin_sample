package com.feel.jeon.koin_sample.repository

import com.feel.jeon.koin_sample.model.User

interface UserRepository {
    fun findUser(name: String, age: Int) : User?
    fun addUser(users: List<User>)
}

class UserRepositoryImpl: UserRepository {

    private val _users = arrayListOf<User>()

    override fun findUser(name: String, age: Int): User? {
        return _users.firstOrNull {it.name == name && it.age == age}
    }

    override fun addUser(users: List<User>) {
        _users.addAll(users)
    }

}