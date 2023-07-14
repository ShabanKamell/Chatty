package com.example.chatty.common.data.database

import androidx.room.*
import com.example.chatty.App

@Database(entities = [MessageEntity::class], version = 1)
abstract class MessagesDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao

    companion object {
        fun build(): MessagesDatabase {
            return Room.databaseBuilder(
                App.context,
                MessagesDatabase::class.java,
                "messages-db"
            ).build()
        }
    }
}