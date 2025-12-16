package dev.kavrin.mini_chat_backend.service.store

import java.time.Instant
import java.util.UUID

data class ChatRecord(
    val id: UUID,
    val title: String?,
    val createdAt: Instant
)