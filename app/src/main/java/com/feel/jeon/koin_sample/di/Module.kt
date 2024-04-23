package com.feel.jeon.koin_sample.di

import com.feel.jeon.koin_sample.UserPresenter
import com.feel.jeon.koin_sample.repository.UserRepository
import com.feel.jeon.koin_sample.repository.UserRepositoryImpl
import org.koin.core.instance.SingleInstanceFactory
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
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
 */
val repositoryModule = module {
    single {
        UserRepositoryImpl()
    }
    factory { UserPresenter(userRepository = get()) }

//    singleOf(::UserRepositoryImpl)
//    factoryOf(::UserPresenter)
}