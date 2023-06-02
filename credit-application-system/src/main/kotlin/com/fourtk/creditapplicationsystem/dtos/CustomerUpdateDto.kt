package com.fourtk.creditapplicationsystem.dtos

import com.fourtk.creditapplicationsystem.entities.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Required field")
    val firstName: String,
    @field:NotEmpty(message = "Required field")
    val lastName: String,
    @field:NotEmpty(message = "Required field")
    val zipCode: String,
    @field:NotEmpty(message = "Required field")
    val street: String,
    @field:NotNull(message = "Required field")
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
