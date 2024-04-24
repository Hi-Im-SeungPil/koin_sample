package com.feel.jeon.koin_sample.viewModel

import androidx.lifecycle.ViewModel
import com.feel.jeon.koin_sample.UserPresenter
import com.feel.jeon.koin_sample.model.User
import com.feel.jeon.koin_sample.repository.UserRepository

class MainViewModel(
    private val userPresenter: UserPresenter,
    private val userRepository: UserRepository,
    private val userPresenter2: UserPresenter,
    private val userRepository2: UserRepository
) : ViewModel() {

    fun addUser(users: List<User>) {
        userRepository.addUser(users)
    }

    fun sayHello(name: String, age: Int): String {
        return userPresenter.sayHello(name, age)
    }

    fun secondAddUser(users: List<User>) {
        userRepository2.addUser(users)
    }

    fun secondSayHello(name: String, age: Int): String {
        return userPresenter2.sayHello(name, age)
    }
}