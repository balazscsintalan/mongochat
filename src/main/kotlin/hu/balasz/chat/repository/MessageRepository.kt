package hu.balasz.chat.repository

import hu.balasz.chat.domain.Message
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.Tailable
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface MessageRepository : ReactiveMongoRepository<Message, String> {

    @Tailable
    fun findWithTailableCursorByRoom(room: String): Flux<Message>
}