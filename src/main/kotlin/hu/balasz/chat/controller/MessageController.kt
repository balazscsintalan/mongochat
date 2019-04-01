package hu.balasz.chat.controller

import hu.balasz.chat.dto.MessageBody
import hu.balasz.chat.dto.MessageView
import hu.balasz.chat.service.MessageService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
@CrossOrigin
@RequestMapping("/messages")
class MessageController(val messageService: MessageService) {

    @GetMapping(produces = [(MediaType.TEXT_EVENT_STREAM_VALUE)])
    fun allMessages(@RequestParam room: String): Flux<MessageView> {
        return this.messageService.findWithTailableCursorByRoom(room)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun newMessage(@RequestBody messageBody: MessageBody) {
        this.messageService.newMessage(messageBody)
    }
}