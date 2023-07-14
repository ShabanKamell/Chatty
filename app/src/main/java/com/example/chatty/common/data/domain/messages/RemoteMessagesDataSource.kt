package com.example.chatty.common.data.domain.messages

import com.example.chatty.common.data.model.Message

class RemoteMessagesDataSource(private val myApi: MessagesApi) : MessagesDataSource {
    override suspend fun fetchMessages(): List<Message> {
        try {
            val response = myApi.fetchMessages()
            if (response.isSuccessful) {
                val data = response.body()
                if (data != null) {
                    return data
                }
            }
        } catch (e: Exception) {
            // Handle error
        }
        return emptyList()
    }
}