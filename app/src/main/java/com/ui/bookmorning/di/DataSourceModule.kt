package com.ui.bookmorning.di

import android.content.Context
import android.content.SharedPreferences
import com.tencent.mmkv.MMKV
import com.ui.bookmorning.data.cache.KeyValueStorage
import com.ui.bookmorning.data.cache.MMKVPrefStorage
import com.ui.bookmorning.data.cache.SharedPrefStorage
import com.ui.bookmorning.data.datasource.auth.AuthLocalDataSource
import com.ui.bookmorning.data.datasource.auth.AuthRemoteDataSource
import com.ui.bookmorning.data.datasource.book.BookRemoteDataSource
import com.ui.bookmorning.data.service.TokenService
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single {
        BookRemoteDataSource(get())
    }
}

val authRemoteDataSource = module {
    single {
        AuthRemoteDataSource(
            authService = get()
        )
    }
}

val authLocalDataSource = module {
    single {
        AuthLocalDataSource(
            tokenService = get()
        )
    }
}

val tokenService = module {
    single {
        TokenService(
            keyValueStorage = get()
        )
    }
}

val keyValueStorage = module {
    single {
        MMKVPrefStorage(
            mmKV = get()
        ) as KeyValueStorage
    }
}

val sharedPreferences = module {
    single<SharedPreferences> {
        val context: Context = get()
        context.getSharedPreferences("com.sci.bookmorning.prefs", Context.MODE_PRIVATE)
    }

    single {
        MMKV.defaultMMKV()
    }
}