package com.example.chatty.common.data.domain.messages

import com.example.chatty.common.data.database.MessageDao
import com.example.chatty.common.data.database.MessageEntity
import com.example.chatty.common.data.model.Message

class LocalMessagesDataSource(private val myDao: MessageDao) : MessagesDataSource {
    override suspend fun fetchMessages(): List<Message> {
        val messages = myDao.getAllMessages().map {
            Message(it.sender, it.text)
        }
        if (messages.isEmpty()) {
            val remoteData = myDao.getAllMessages()
            myDao.insertMessages(remoteData.map {
                MessageEntity(
                    sender = it.sender,
                    text = it.text
                )
            })
            return remoteData.map {
                Message(it.sender, it.text)
            }
        }
        return messages
    }

    suspend fun saveData(data: List<Message>) {
        val entities = data.map {
            MessageEntity(
                sender = it.sender,
                text = it.text
            )
        }
        myDao.insertMessages(entities)
    }
}
