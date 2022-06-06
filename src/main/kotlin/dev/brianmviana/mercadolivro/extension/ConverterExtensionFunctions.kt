package dev.brianmviana.mercadolivro.extension

import dev.brianmviana.mercadolivro.controller.request.PostBookRequest
import dev.brianmviana.mercadolivro.controller.request.PostCustomerRequest
import dev.brianmviana.mercadolivro.controller.request.PutCustomerRequest
import dev.brianmviana.mercadolivro.enums.BookStatus
import dev.brianmviana.mercadolivro.model.Book
import dev.brianmviana.mercadolivro.model.Customer

fun PostCustomerRequest.toCustomer(): Customer {
    return Customer(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomer(id: Int): Customer {
    return Customer(id = id, name = this.name, email = this.email)
}

fun PostBookRequest.toBook(customer: Customer): Book {
    return Book(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}