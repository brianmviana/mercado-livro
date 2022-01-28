package dev.brianmviana.mercadolivro.extension

import dev.brianmviana.mercadolivro.controller.resquest.PostCustomerRequest
import dev.brianmviana.mercadolivro.controller.resquest.PutCustomerRequest
import dev.brianmviana.mercadolivro.model.Customer

fun PostCustomerRequest.toCustomer(): Customer {
    return Customer(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomer(id: Int): Customer {
    return Customer(id = id, name = this.name, email = this.email)
}