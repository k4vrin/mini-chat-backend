package dev.kavrin.mini_chat_backend.service.store

import org.springframework.stereotype.Component
import java.time.Instant
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import kotlin.also

@Component
class InMemoryChatStore {

    private val chats = ConcurrentHashMap<UUID, ChatRecord>()
    private val messages = ConcurrentHashMap<UUID, MutableList<MessageRecord>>()

    fun createChat(title: String?): ChatRecord {
        return ChatRecord(
            id = UUID.randomUUID(),
            title = title,
            createdAt = Instant.now()
        ).also { chat ->
            chats[chat.id] = chat
        }

    }
    fun findChat(id: UUID): ChatRecord? {
        return chats[id]
    }

    fun addMessage(chatId: UUID, content: String): MessageRecord {
        return MessageRecord(
            id = UUID.randomUUID(),
            chatId = chatId,
            content = content,
            createdAt = Instant.now()
        ).also { messageRecord ->
            val msgs = messages[chatId]?.apply { add(messageRecord) } ?: mutableListOf(messageRecord)
            messages[chatId] = msgs
        }
    }

    fun listMessages(chatId: UUID): List<MessageRecord> {
        return messages[chatId]?.toList() ?: emptyList()
    }
}
