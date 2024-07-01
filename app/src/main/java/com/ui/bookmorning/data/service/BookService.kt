package com.ui.bookmorning.data.service

import android.util.Log
import com.ui.bookmorning.data.model.response.BookResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//1. KtorHelper -> to create HttpClient -> to request https get / post / -> def req , content nego
//2 . Di -> Singleton 2 -> KtorHelper , BookService
//3 . Remote Datasource connect
class BookService(private val httpClient: HttpClient) {
    suspend fun getBook(): BookResponse {
        val bookResponse: BookResponse =  withContext(Dispatchers.IO) {
            val httpResponse: HttpResponse = httpClient.get("user/books_simple")
            // meta , http status , body -> json
            httpResponse.body()
        }
        return bookResponse
    }
}

//ViewModel builder
// Global.launch = Dispther.default // CPU
// viewModel.getBookList -> IO
// repo.getBookList -> IO
// remote. getBookList -> IO
// service.getBookList -> IO
// httpClient.get , httpRes.body () -> IO




