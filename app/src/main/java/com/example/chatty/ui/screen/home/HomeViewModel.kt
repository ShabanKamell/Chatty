package com.example.chatty.ui.screen.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.chatty.common.data.model.Conversation

class HomeViewModel : ViewModel() {
    val conversations = mutableStateListOf(
        Conversation("Alice", "Hi there!", "12:30 PM"),
        Conversation("Bob", "Hey, how's it going?", "12:28 PM"),
        Conversation("Charlie", "Yo, what's up?", "12:15 PM"),
        Conversation("Dave", "Hey there! Long time no see.", "11:45 AM"),
        Conversation("Eve", "Hiya! How's your day going?", "11:30 AM"),
    )
}