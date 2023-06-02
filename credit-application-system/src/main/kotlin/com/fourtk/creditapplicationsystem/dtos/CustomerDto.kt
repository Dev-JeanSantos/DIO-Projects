package com.fourtk.creditapplicationsystem.dtos

import com.fourtk.creditapplicationsystem.entities.Address
import com.fourtk.creditapplicationsystem.entities.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Required field")
    val firstName: String,
    @field:NotEmpty(message = "Required field")
    val lastName: String,
    @field:NotNull(message = "Required field")
    val income: BigDecimal,
    @field:Email(message = "Required field")
    val email: String,
    @field:CPF(message = "Required field")
    val cpf: String,
    @field:NotEmpty(message = "Required field")
    val password: String,
    @field:NotEmpty(message = "Required field")
    val zipCode: String,
    @field:NotEmpty(message = "Required field")
    val street: String,
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        email = this.email,
        password = this.password,
        cpf = this.cpf,
        income = this.income,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}