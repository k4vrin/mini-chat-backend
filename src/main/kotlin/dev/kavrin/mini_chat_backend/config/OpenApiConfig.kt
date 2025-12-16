package dev.kavrin.mini_chat_backend.config

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun openAPI(): OpenAPI =
        OpenAPI()
            .info(
                Info()
                    .title("Mini Chat Backend API")
                    .description("Minimal chat service built with Spring Boot + Kotlin")
                    .version("v1")
                    .contact(Contact().name("Kavrin"))
                    .license(License().name("MIT"))
            )
            .externalDocs(
                ExternalDocumentation()
                    .description("Project README")
                    .url("https://github.com/kavrin/mini-chat-backend")
            )
}
