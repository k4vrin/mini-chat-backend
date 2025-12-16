package dev.kavrin.mini_chat_backend.service

import java.lang.RuntimeException
import java.util.UUID

class ChatNotFoundException(chatId: UUID) : RuntimeException("Chat with id $chatId not found") {
}