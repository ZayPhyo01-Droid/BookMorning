package com.ui.bookmorning.data.service

import android.util.Log
import com.ui.bookmorning.data.model.response.BookResponse
import com.ui.bookmorning.exceptions.ApiException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//1. KtorHelper -> to create HttpClient -> to request https get / post / -> def req , content nego
//2 . Di -> Singleton 2 -> KtorHelper , BookService
//3 . Remote Datasource connect
class BookService(private val httpClient: HttpClient) {
    suspend fun getBook(): Result<BookResponse> {
        try {
            val httpResponse: HttpResponse = httpClient.get("user/books_simple"){
                headers {
                    append("ngrok-skip-browser-warning", "69420")
                }
            }
            // -> 200 ? Success else Fail
            when(httpResponse.status) {
                //200
                HttpStatusCode.OK -> {
                    // Success
                    val response: BookResponse? = httpResponse.body()
                    if (response != null) {
                        // Success
                        return Result.success(response)
                    }
                    // Fail
                    return Result.failure(
                        ApiException(
                            code = httpResponse.status.value,
                            message = "Something went wrong"
                        )
                    )
                }

                else -> return Result.failure(
                    ApiException(
                        code = httpResponse.status.value,
                        message = "Something went wrong"
                    )
                )
            }
        }catch (e: Exception) {
            // Fail or Success?
            return Result.failure(e)
        }
    }
}

//ViewModel builder
// Global.launch = Dispther.default // CPU
// viewModel.getBookList -> IO
// repo.getBookList -> IO
// remote. getBookList -> IO
// service.getBookList -> IO
// httpClient.get , httpRes.body () -> IO




