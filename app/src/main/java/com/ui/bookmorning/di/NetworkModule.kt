package com.ui.bookmorning.di

import com.ui.bookmorning.data.network.KtorHelper
import com.ui.bookmorning.data.service.BookService
import org.koin.core.scope.get
import org.koin.dsl.module

// ktor obj -> KtorHelper
// di -> service , ktor -> service inject

val networkModule = module {
    single {
        KtorHelper().getClient() // HttpClient -> Singleton
    }

    single {
        BookService(
            get()
        )
    }
}




