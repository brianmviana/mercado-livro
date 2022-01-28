package dev.brianmviana.mercadolivro.service

import dev.brianmviana.mercadolivro.model.Customer
import dev.brianmviana.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRespository : CustomerRepository
){

    fun create(customer: Customer) {
        customerRespository.save(customer)
    }

    fun readAll(name: String?): List<Customer> {
        name?.let {
            return customerRespository.findByNameContaining(it)
        }
        return customerRespository.findAll().toList()
    }

    fun readOne(id: Int): Customer {
        return customerRespository.findById(id).orElseThrow()
    }

    fun update(customer: Customer) {
        if (customerRespository.existsById(customer.id!!)) {
            throw Exception();
        }
        customerRespository.save(customer)
    }

    fun delete(id: Int) {
        if (customerRespository.existsById(id)) {
            throw Exception();
        }
        customerRespository.deleteById(id)
    }

}