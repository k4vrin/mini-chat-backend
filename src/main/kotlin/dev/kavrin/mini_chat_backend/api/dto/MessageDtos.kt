package dev.kavrin.mini_chat_backend.api.dto

import dev.kavrin.mini_chat_backend.service.store.MessageRecord
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.Instant
import java.util.UUID

data class CreateMessageRequest(
    @field:NotBlank
    @field:Size(max = 2000)
    val content: String
)

data class MessageResponse(
    val id: UUID,
    val chatId: UUID,
    val content: String,
    val createdAt: Instant
) {
    companion object {
        fun from(record: MessageRecord) = MessageResponse(
            id = record.id,
            chatId = record.chatId,
            content = record.content,
            createdAt = record.createdAt
        )
    }
}

fun MessageRecord.toMessageResponse(): MessageResponse = MessageResponse.from(this)
