package com.example.chatty.ui.screen.chat

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatty.common.data.domain.messages.MessagesRepository
import com.example.chatty.common.data.model.Message
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    private val messagesRepository by lazy { MessagesRepository.build() }

    var messages = mutableStateListOf(
        Message("Alice", "Hi there!"),
        Message("Bob", "Hey, how's it going?"),
        Message("Alice", "Pretty good, thanks. How about you?"),
        Message("Bob", "Not too bad. Just hanging out."),
        Message("Alice", "Cool, cool. So, what have you been up to?"),
        Message("Bob", "Not much, just working on some stuff. You?"),
        Message("Alice", "Same here, just trying to stay busy."),
        Message("Bob", "Gotcha. Well, it was good talking to you!"),
        Message("Alice", "Yeah, you too! Take care.")
    )

    fun fetchMessages() {
        viewModelScope.launch {
            val items = messagesRepository.fetchMessages()
            messages.addAll(items)
        }
    }
}