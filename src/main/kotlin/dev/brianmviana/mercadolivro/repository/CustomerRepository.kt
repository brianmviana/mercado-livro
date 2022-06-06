package dev.brianmviana.mercadolivro.repository

import dev.brianmviana.mercadolivro.model.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Int> {

    fun findByNameContaining(name: String): List<Customer>

}