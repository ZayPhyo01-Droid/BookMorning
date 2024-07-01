package com.ui.bookmorning.data.repository

import com.ui.bookmorning.data.datasource.BookRemoteDataSource
import com.ui.bookmorning.domain.model.BookModel

class BookRepository(
    private val bookRemoteDataSource: BookRemoteDataSource
) {

    suspend fun getBookList(): List<BookModel> = bookRemoteDataSource.getBookList()
}