package com.ui.bookmorning.data.repository

import com.ui.bookmorning.data.datasource.book.BookRemoteDataSource
import com.ui.bookmorning.domain.model.book.BookModel

class BookRepository(
    private val bookRemoteDataSource: BookRemoteDataSource
) {

    suspend fun getBookList(): Result<List<BookModel>> = bookRemoteDataSource.getBookList()
}