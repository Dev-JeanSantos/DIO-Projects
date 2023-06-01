package com.fourtk.creditapplicationsystem.dtos

import com.fourtk.creditapplicationsystem.entities.Address
import com.fourtk.creditapplicationsystem.entities.Customer
import com.fourtk.creditapplicationsystem.services.impl.CustomerService
import java.math.BigDecimal

data class CustomerDto(
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val email: String,
    val cpf: String,
    val password: String,
    val zipCode: String,
    val street: String,
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}