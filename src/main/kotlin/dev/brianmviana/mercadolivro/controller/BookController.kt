package dev.brianmviana.mercadolivro.controller

import dev.brianmviana.mercadolivro.controller.request.PostBookRequest
import dev.brianmviana.mercadolivro.extension.toBook
import dev.brianmviana.mercadolivro.service.BookService
import dev.brianmviana.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController(
    val customerService: CustomerService,
    val bookService: BookService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.readOne(request.customerId)
        bookService.create(request.toBook(customer))
    }

}