package dev.brianmviana.mercadolivro.controller

import dev.brianmviana.mercadolivro.model.Consumer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("consumer")
class ConsumerController {

    @GetMapping
    fun getConsumer(): Consumer {
        return Consumer("1", "teste", "email@email.com")
    }

}