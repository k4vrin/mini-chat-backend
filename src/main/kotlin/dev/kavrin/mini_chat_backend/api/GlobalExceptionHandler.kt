package dev.kavrin.mini_chat_backend.api

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): Map<String, String> {
        return mapOf("error" to (ex.message ?: "An unexpected error occurred"))
    }
}