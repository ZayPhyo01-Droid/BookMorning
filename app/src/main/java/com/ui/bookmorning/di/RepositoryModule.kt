package com.ui.bookmorning.di

import com.ui.bookmorning.data.repository.BookRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        BookRepository(get())
    }
}