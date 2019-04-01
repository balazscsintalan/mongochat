package hu.balasz.chat.service

import hu.balasz.chat.domain.Message
import hu.balasz.chat.dto.MessageBody
import hu.balasz.chat.dto.MessageView
import hu.balasz.chat.repository.MessageRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.LocalDateTime

@Service
class MessageService(val messageRepository: MessageRepository) {
    fun findWithTailableCursorByRoom(room: String): Flux<MessageView> {
        return this.messageRepository.findWithTailableCursorByRoom(room)
                .map { MessageView(it.text, it.user, it.creationDate) }
    }

    fun newMessage(messageBody: MessageBody) {
        this.messageRepository.save(Message(null, messageBody.text, messageBody.room, messageBody.user, LocalDateTime.now())).subscribe()
    }
}