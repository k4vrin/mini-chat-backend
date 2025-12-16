package dev.kavrin.mini_chat_backend.api.dto

import dev.kavrin.mini_chat_backend.service.store.ChatRecord
import jakarta.validation.constraints.Size
import java.time.Instant
import java.util.UUID

data class CreateChatRequest(
    @field:Size(min = 1, max = 120)
    val title: String? = null,
)

data class ChatResponse(
    val id: UUID,
    val title: String?,
    val createdAt: Instant
) {
    companion object {
        fun from(record: ChatRecord) = ChatResponse(
            id = record.id,
            title = record.title,
            createdAt = record.createdAt
        )
    }
}

fun ChatRecord.toChatResponse(): ChatResponse = ChatResponse.from(this)
