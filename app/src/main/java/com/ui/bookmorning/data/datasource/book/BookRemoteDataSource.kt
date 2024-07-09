package com.ui.bookmorning.data.datasource.book

import com.ui.bookmorning.data.mapper.toModel
import com.ui.bookmorning.data.service.BookService
import com.ui.bookmorning.domain.model.book.BookModel

class BookRemoteDataSource(
    private val bookService: BookService
) {
    suspend fun getBookList(): Result<List<BookModel>> {
        return bookService.getBook()
            .map { it.toModel() }
    }
}
