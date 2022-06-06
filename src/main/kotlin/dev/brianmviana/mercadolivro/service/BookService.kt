package dev.brianmviana.mercadolivro.service

import dev.brianmviana.mercadolivro.model.Book
import dev.brianmviana.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun create(book: Book) {
        bookRepository.save(book)
    }

}
