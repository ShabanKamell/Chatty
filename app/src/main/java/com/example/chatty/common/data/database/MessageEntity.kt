package com.example.chatty.common.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessageEntity(
    @PrimaryKey(autoGenerate = true) private val id: Int = 0,
    val sender: String,
    val text: String
)
