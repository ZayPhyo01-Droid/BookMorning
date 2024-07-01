package com.ui.bookmorning.di

import com.ui.bookmorning.data.datasource.BookRemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single {
        BookRemoteDataSource(get())
    }
}
