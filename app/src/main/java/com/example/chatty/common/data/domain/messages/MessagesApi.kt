package com.example.chatty.common.data.domain.messages

import com.example.chatty.common.data.model.Message
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface MessagesApi {
    @GET("/data")
    suspend fun fetchMessages(): Response<List<Message>>

    companion object {
        fun build(): MessagesApi {
            return Retrofit.Builder()
                .baseUrl("https://example.com")
                .build()
                .create(MessagesApi::class.java)
        }
    }
}