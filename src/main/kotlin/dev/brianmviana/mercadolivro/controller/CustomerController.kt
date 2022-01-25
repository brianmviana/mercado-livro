package dev.brianmviana.mercadolivro.controller

import dev.brianmviana.mercadolivro.controller.resquest.PostCustomerRequest
import dev.brianmviana.mercadolivro.model.Customer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController {

    val customers = mutableListOf<Customer>()

    @GetMapping
    fun getAll(): List<Customer> {
        return customers
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: String): Customer {
        return customers.filter { it.id == id }.first()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id.toInt() + 1
        }.toString()

        customers.add(Customer(id, customer.name, customer.email))

    }

}