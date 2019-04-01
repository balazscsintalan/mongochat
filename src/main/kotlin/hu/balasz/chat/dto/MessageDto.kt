package hu.balasz.chat.dto

import java.time.LocalDateTime

class MessageView(val id: String, val text: String, val user: String, val timestamp: LocalDateTime)