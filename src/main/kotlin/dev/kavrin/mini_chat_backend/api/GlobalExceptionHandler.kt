package dev.kavrin.mini_chat_backend.api

import dev.kavrin.mini_chat_backend.service.ChatNotFoundException
import dev.kavrin.mini_chat_backend.service.MessagesNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ChatNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleChatNotFoundException(ex: ChatNotFoundException): Map<String, String> {
        return mapOf("error" to ex.message!!)
    }

    @ExceptionHandler(MessagesNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleMessagesNotFoundException(ex: Exception): Map<String, String> {
        return mapOf("error" to ex.message!!)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationException(ex: MethodArgumentNotValidException): Map<String, String> {
        val errorMessage = ex.bindingResult.allErrors.joinToString("; ") { it.defaultMessage ?: "Invalid value" }
        return mapOf("error" to errorMessage)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(ex: Exception): Map<String, String> {
        return mapOf("error" to (ex.message ?: "An unexpected error occurred"))
    }
}