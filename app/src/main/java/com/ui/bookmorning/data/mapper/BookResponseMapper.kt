package com.ui.bookmorning.data.mapper

import com.ui.bookmorning.data.model.response.BookResponse
import com.ui.bookmorning.domain.model.book.BookModel

fun BookResponse.toModel(): List<BookModel> {
    return data.books.map {
        BookModel(
            id = it.id,
            bookCover = it.bookCover.orEmpty(),
            bookName = it.name ?: "",
            bookDescription = it.description.orEmpty()
        )
    }
}