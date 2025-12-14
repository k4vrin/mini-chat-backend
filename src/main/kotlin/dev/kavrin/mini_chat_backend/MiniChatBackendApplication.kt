package dev.kavrin.mini_chat_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MiniChatBackendApplication

fun main(args: Array<String>) {
	runApplication<MiniChatBackendApplication>(*args)
}
