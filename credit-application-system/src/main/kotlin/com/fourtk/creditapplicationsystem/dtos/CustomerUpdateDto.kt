package com.fourtk.creditapplicationsystem.dtos

import com.fourtk.creditapplicationsystem.entities.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(

    val firstName: String,
    val lastName: String,
    val zipCode: String,
    val street: String,
    val income: BigDecimal
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        return customer
    }
}
