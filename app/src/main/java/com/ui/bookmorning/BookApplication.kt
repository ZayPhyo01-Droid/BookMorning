package com.ui.bookmorning

import android.app.Application
import com.ui.bookmorning.di.networkModule
import com.ui.bookmorning.di.remoteDataSourceModule
import com.ui.bookmorning.di.repositoryModule
import com.ui.bookmorning.di.viewModelModule
import org.koin.core.context.startKoin

class BookApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                viewModelModule,
                networkModule,
                repositoryModule,
                remoteDataSourceModule
            )
        }
    }
}