package com.ui.bookmorning.di

import com.ui.bookmorning.ui.viewmodel.BookViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        BookViewModel(
            get()
        )
    }
}

