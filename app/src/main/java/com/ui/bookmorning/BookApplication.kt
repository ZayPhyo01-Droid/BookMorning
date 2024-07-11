package com.ui.bookmorning

import android.app.Application
import com.tencent.mmkv.MMKV
import com.ui.bookmorning.di.authLocalDataSource
import com.ui.bookmorning.di.authRemoteDataSource
import com.ui.bookmorning.di.authRepositoryModule
import com.ui.bookmorning.di.authViewModelModule
import com.ui.bookmorning.di.keyValueStorage
import com.ui.bookmorning.di.networkModule
import com.ui.bookmorning.di.remoteDataSourceModule
import com.ui.bookmorning.di.repositoryModule
import com.ui.bookmorning.di.sharedPreferences
import com.ui.bookmorning.di.tokenService
import com.ui.bookmorning.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BookApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
        startKoin {
            modules(
                viewModelModule,
                networkModule,
                repositoryModule,
                remoteDataSourceModule
            )
            modules(
                authRepositoryModule,
                authViewModelModule,
                authRemoteDataSource,
                authLocalDataSource,
                keyValueStorage,
                tokenService,
                sharedPreferences
            )
            androidContext(this@BookApplication)
        }
    }
}