package dev.kavrin.mini_chat_backend.api

import dev.kavrin.mini_chat_backend.api.dto.ChatRequest
import dev.kavrin.mini_chat_backend.api.dto.ChatResponse
import dev.kavrin.mini_chat_backend.service.ChatService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/chat")
class ChatController(
    private val chatService: ChatService
) {

    @PostMapping
    fun chat(
        @Valid @RequestBody request: ChatRequest,
    ): ChatResponse {
        val reply = chatService.generateReply(request.message)
        return ChatResponse(reply)
    }
}