package com.feel.jeon.koin_sample.di

import com.feel.jeon.koin_sample.UserPresenter
import com.feel.jeon.koin_sample.repository.UserRepository
import com.feel.jeon.koin_sample.repository.UserRepositoryImpl
import com.feel.jeon.koin_sample.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.instance.SingleInstanceFactory
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

/**
 * single
 *
 * 예를 들면 Retrofit 통신 객체처럼 App 전체 주기 동안
 * 다일 인스턴스로 존재하는 객체를 싱글톤처럼 생성하여
 * 주입하게 합니다.
 *
 *
 *
 * facctory
 *
 * single과 반대로 항상 객체를 생성하여 주입합니다.
 * 요청(inject, get) 할 때마다 새로운 객체를 생성하여 주입.
 *
 *
 * viewModel
 *
 * viewModel에 대한 Module 선언입니다.
 *
 * 중복되는 클래스가 있을 경우 qualifier 사용
 */
val repositoryModule = module {
    single(qualifier = named("one")) {
        UserRepositoryImpl()
    }
    single(qualifier = named("two")) {
        UserRepositoryImpl()
    }
    factory(qualifier = named("first")) { UserPresenter(userRepository = get(qualifier = named("one"))) }
    factory(qualifier = named("second")) { UserPresenter(userRepository = get(qualifier = named("two"))) }

//    이렇게도 가능
//    singleOf(::UserRepositoryImpl)
//    factoryOf(::UserPresenter)
}

val viewModelModule = module {
    viewModel {
        MainViewModel(
            userPresenter = get(qualifier = named("one")),
            userRepository = get(qualifier = named("first")),
            userPresenter2 =  get(qualifier = named("two")),
            userRepository2 = get(qualifier = named("second"))
        )
    }
}