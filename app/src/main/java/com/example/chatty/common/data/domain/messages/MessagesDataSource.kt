package com.example.chatty.common.data.domain.messages

import com.example.chatty.common.data.model.Message

interface MessagesDataSource {
    suspend fun fetchMessages(): List<Message>
}