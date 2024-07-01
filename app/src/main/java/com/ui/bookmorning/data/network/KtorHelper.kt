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
                url("http://54.179.102.152/api/")
            }
            install(ContentNegotiation) {
                json()
            }
        }
    }
}