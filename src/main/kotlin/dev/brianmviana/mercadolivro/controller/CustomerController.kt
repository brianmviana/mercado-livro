package dev.brianmviana.mercadolivro.controller

import dev.brianmviana.mercadolivro.controller.resquest.PostCustomerRequest
import dev.brianmviana.mercadolivro.controller.resquest.PutCustomerRequest
import dev.brianmviana.mercadolivro.model.Customer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController {

    val customers = mutableListOf<Customer>()

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

    @GetMapping
    fun readAll(): List<Customer> {
        return customers
    }

    @GetMapping("/{id}")
    fun readOne(@PathVariable id: String): Customer {
        return customers.filter { it.id == id }.first()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody customer: PutCustomerRequest) {
        customers.filter { it.id == id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }


}