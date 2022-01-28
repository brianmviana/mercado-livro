package dev.brianmviana.mercadolivro.controller

import dev.brianmviana.mercadolivro.controller.resquest.PostCustomerRequest
import dev.brianmviana.mercadolivro.controller.resquest.PutCustomerRequest
import dev.brianmviana.mercadolivro.extension.toCustomer
import dev.brianmviana.mercadolivro.model.Customer
import dev.brianmviana.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(val customerService: CustomerService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        customerService.create(customer.toCustomer())
    }

    @GetMapping
    fun readAll(@RequestParam name: String?): List<Customer> {
        return customerService.readAll(name)
    }

    @GetMapping("/{id}")
    fun readOne(@PathVariable id: Int): Customer {
        return customerService.readOne(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        customerService.update(id, customer.toCustomer(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }

}