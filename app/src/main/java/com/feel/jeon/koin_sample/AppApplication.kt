package com.feel.jeon.koin_sample

import android.app.Application
import com.feel.jeon.koin_sample.di.repositoryModule
import com.feel.jeon.koin_sample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // koin 사용하기 위해서 선언.
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules(repositoryModule)
            modules(viewModelModule)
        }
    }
}