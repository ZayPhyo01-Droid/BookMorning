package com.ui.bookmorning.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//BookResponse DTO
@Serializable
data class BookResponse(
    val code: Int,
    val message: String,
    val data: BookData
)

@Serializable
data class BookData(
    val books: List<Book>
)

@Serializable
data class Book(
    val id: String,
    val name: String?,
    val description: String?,
    @SerialName("book_cover")
    val bookCover: String?,
    val author: Author,
    val category: Category,
    val rating: Double,
    val price: Double
)

@Serializable
data class Author(
    val id: String,
    val name: String?,
    val description: String?
)

@Serializable
data class Category(
    val id: String,
    @SerialName("category_name")
    val categoryName: String?
)
