package com.ui.bookmorning.di

import com.ui.bookmorning.data.datasource.auth.AuthRemoteDataSource
import com.ui.bookmorning.data.datasource.book.BookRemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single {
        BookRemoteDataSource(get())
    }
}

val authRemoteDataSource = module {
    single {
        AuthRemoteDataSource()
    }
}
