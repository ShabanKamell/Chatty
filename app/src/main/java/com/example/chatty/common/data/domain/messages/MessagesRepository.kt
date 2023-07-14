package com.example.chatty.common.data.domain.messages

import com.example.chatty.common.data.database.MessagesDatabase
import com.example.chatty.common.data.model.Message

class MessagesRepository(
    private val remoteDataSource: RemoteMessagesDataSource,
    private val localDataSource: LocalMessagesDataSource
) : MessagesDataSource {
    override suspend fun fetchMessages(): List<Message> {
        val localData = localDataSource.fetchMessages()
        return localData.ifEmpty {
            val remoteData = remoteDataSource.fetchMessages()
            localDataSource.saveData(remoteData)
            remoteData
        }
    }

    companion object {
        fun build(): MessagesRepository {

            val myDatabase = MessagesDatabase.build()
            val messageDao = myDatabase.messageDao()

            val api = MessagesApi.build()
            val remoteDataSource = RemoteMessagesDataSource(api)
            val localDataSource = LocalMessagesDataSource(messageDao)

            return MessagesRepository(remoteDataSource, localDataSource)
        }
    }
}