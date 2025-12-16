package dev.kavrin.mini_chat_backend.service.store

import java.time.Instant
import java.util.UUID


data class MessageRecord(
    val id: UUID,
    val chatId: UUID,
    val content: String,
    val createdAt: Instant
)
