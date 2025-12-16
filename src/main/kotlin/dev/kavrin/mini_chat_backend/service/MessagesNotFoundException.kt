package dev.kavrin.mini_chat_backend.service

import java.lang.RuntimeException
import java.util.UUID

class MessagesNotFoundException(chatId: UUID) : RuntimeException("Did not find messages for chat with id $chatId") {
}