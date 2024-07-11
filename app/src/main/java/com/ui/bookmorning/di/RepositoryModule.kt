package com.ui.bookmorning.di

import com.ui.bookmorning.data.repository.BookRepository
import com.ui.bookmorning.data.repository.auth.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        BookRepository(get())
    }
}


val authRepositoryModule = module {
    single {
        AuthRepository(
            authRemoteDataSource = get(),
            authLocalDataSource = get()
        )
    }
}