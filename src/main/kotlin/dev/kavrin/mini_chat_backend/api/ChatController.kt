package dev.kavrin.mini_chat_backend.api

import dev.kavrin.mini_chat_backend.api.dto.ChatResponse
import dev.kavrin.mini_chat_backend.api.dto.CreateChatRequest
import dev.kavrin.mini_chat_backend.api.dto.CreateMessageRequest
import dev.kavrin.mini_chat_backend.api.dto.MessageResponse
import dev.kavrin.mini_chat_backend.api.dto.toChatResponse
import dev.kavrin.mini_chat_backend.api.dto.toMessageResponse
import dev.kavrin.mini_chat_backend.service.ChatService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/chats")
@Tag(name = "Chats", description = "Chat lifecycle and message operations")
class ChatController(
    private val chatService: ChatService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
        summary = "Create a new chat",
        description = "Creates a chat thread with an optional title.",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "Chat created",
                content = [Content(schema = Schema(implementation = ChatResponse::class))]
            ),
            ApiResponse(responseCode = "400", description = "Invalid input")
        ]
    )
    fun createChat(
        @Valid @RequestBody request: CreateChatRequest,
    ): ChatResponse {
        return chatService.createChat(request.title).toChatResponse()
    }

    @GetMapping("/{chatId}")
    @Operation(
        summary = "Get chat metadata",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Chat found",
                content = [Content(schema = Schema(implementation = ChatResponse::class))]
            ),
            ApiResponse(responseCode = "404", description = "Chat not found")
        ]
    )
    fun getChat(
        @Parameter(description = "Chat identifier") @PathVariable chatId: UUID
    ): ChatResponse {
        return chatService.getChat(chatId).toChatResponse()
    }

    @PostMapping("/{chatId}/messages")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
        summary = "Add a message to a chat",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "Message created",
                content = [Content(schema = Schema(implementation = MessageResponse::class))]
            ),
            ApiResponse(responseCode = "400", description = "Invalid input"),
            ApiResponse(responseCode = "404", description = "Chat not found")
        ]
    )
    fun addMessage(
        @Parameter(description = "Chat identifier") @PathVariable chatId: UUID,
        @Valid @RequestBody request: CreateMessageRequest
    ): MessageResponse {
        return chatService.addMessage(chatId, request.content).toMessageResponse()
    }

    @GetMapping("/{chatId}/messages")
    @Operation(
        summary = "List messages in a chat",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Messages returned",
                content = [Content(schema = Schema(implementation = MessageResponse::class))]
            ),
            ApiResponse(responseCode = "404", description = "Chat not found")
        ]
    )
    fun listMessages(
        @Parameter(description = "Chat identifier") @PathVariable chatId: UUID
    ): List<MessageResponse> {
        return chatService.listMessages(chatId).map { it.toMessageResponse() }
    }

}
