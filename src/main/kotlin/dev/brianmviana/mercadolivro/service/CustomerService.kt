package dev.brianmviana.mercadolivro.service

import dev.brianmviana.mercadolivro.model.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customers = mutableListOf<Customer>()

    fun create(customer: Customer) {
        customer.id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        }.toString()

        customers.add(customer)
    }

    fun readAll(name: String?): List<Customer> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun readOne(id: String): Customer {
        return customers.filter { it.id == id }.first()
    }

    fun update(customer: Customer) {
        customers.filter { it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }

}