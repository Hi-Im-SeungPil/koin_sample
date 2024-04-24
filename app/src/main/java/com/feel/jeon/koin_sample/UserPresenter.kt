package com.feel.jeon.koin_sample

import com.feel.jeon.koin_sample.repository.UserRepository

class
UserPresenter(private val userRepository: UserRepository) {

    fun sayHello(name: String, age: Int): String {
        val foundUser = userRepository.findUser(name, age)
        return foundUser?.let { "Hello '${it.name}' your age is ${it.age}from $this" } ?: "NOT FOUND!"
    }
}