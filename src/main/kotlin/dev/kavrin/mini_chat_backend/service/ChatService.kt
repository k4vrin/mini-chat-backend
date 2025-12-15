package dev.kavrin.mini_chat_backend.service

import org.springframework.stereotype.Service

@Service
class ChatService {
    fun generateReply(message: String): String {
        // Simple echo logic for demonstration purposes
        return "You said: $message"
    }
}