package hu.balasz.chat.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "messages")
data class Message(
        @Id val id: String?,
        val text: String,
        val room: String,
        val user: String,
        val creationDate: LocalDateTime
)