package dev.kavrin.mini_chat_backend.api.dto

import jakarta.validation.constraints.NotBlank

data class ChatRequest(
    @field:NotBlank
    val message: String
)
