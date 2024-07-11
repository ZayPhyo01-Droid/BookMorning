package com.ui.bookmorning.data.service

import com.ui.bookmorning.data.model.request.LoginRequest
import com.ui.bookmorning.data.model.response.BookResponse
import com.ui.bookmorning.data.model.response.LoginResponse
import com.ui.bookmorning.exceptions.ApiException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.http.headers

class AuthService(
    private val httpClient: HttpClient
) {
    suspend fun login(loginRequest: LoginRequest): Result<LoginResponse> {
        try {
            val httpResponse: HttpResponse = httpClient.post("auth/login"){
                headers {
                    append("ngrok-skip-browser-warning", "69420")
                }
                contentType(ContentType.Application.Json)
                setBody(loginRequest)
            }
            // -> 200 ? Success else Fail
            when(httpResponse.status) {
                //200
                HttpStatusCode.OK -> {
                    // Success
                    val response: LoginResponse? = httpResponse.body()
                    if (response != null && response.data?.accessToken != null) {
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