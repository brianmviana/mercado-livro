package dev.brianmviana.mercadolivro.repository

import dev.brianmviana.mercadolivro.model.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Int> {

    fun findByNameContaining(name: String): List<Book>

}