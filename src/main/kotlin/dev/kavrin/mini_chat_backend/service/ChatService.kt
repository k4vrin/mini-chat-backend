package dev.kavrin.mini_chat_backend.service

import dev.kavrin.mini_chat_backend.service.store.ChatRecord
import dev.kavrin.mini_chat_backend.service.store.InMemoryChatStore
import dev.kavrin.mini_chat_backend.service.store.MessageRecord
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ChatService(
    private val chatStore: InMemoryChatStore
) {
    fun createChat(title: String?): ChatRecord {
        return chatStore.createChat(title)
    }

    fun getChat(chatId: UUID): ChatRecord {
        return chatStore.findChat(chatId) ?: throw ChatNotFoundException(chatId)
    }

    fun addMessage(chatId: UUID, content: String): MessageRecord {
        ensureChatExists(chatId)
        return chatStore.addMessage(chatId, content)
    }

    fun listMessages(chatId: UUID): List<MessageRecord> {
        ensureChatExists(chatId)
        return chatStore.listMessages(chatId)
    }

    private fun ensureChatExists(chatId: UUID) {
        if (chatStore.findChat(chatId) == null) {
            throw ChatNotFoundException(chatId)
        }
    }
}
