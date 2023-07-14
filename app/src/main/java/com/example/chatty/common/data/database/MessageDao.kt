package com.example.chatty.common.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MessageDao {
    @Query("SELECT * FROM messages")
    fun getAllMessages(): List<MessageEntity>

    @Insert
    fun insertMessages(message: List<MessageEntity>)

}