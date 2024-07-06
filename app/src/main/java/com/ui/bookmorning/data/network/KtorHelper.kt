package com.ui.bookmorning.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json


// network objection (httpclient)
class KtorHelper {
    fun getClient(): HttpClient {
        return HttpClient(Android) {
            defaultRequest {
                url("https://74af55de-7922-44fa-a753-37e35aa5611f.mock.pstmn.io/api/")
            }
            install(ContentNegotiation) {
                json()
            }
        }
    }
}