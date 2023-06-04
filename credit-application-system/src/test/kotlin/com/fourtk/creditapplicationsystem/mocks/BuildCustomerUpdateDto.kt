package com.fourtk.creditapplicationsystem.mocks

import com.fourtk.creditapplicationsystem.dtos.CustomerUpdateDto
import java.math.BigDecimal

object BuildCustomerUpdateDto {
    fun buildCustomerUpdateDto(
        firstName: String = "Fulano-Update",
        lastName: String = "Silva-Update",
        zipCode: String = "654321-Update",
        street: String = "Rua A-Update",
        income: BigDecimal = BigDecimal.valueOf(1000.0),
    ) = CustomerUpdateDto(
        firstName = firstName,
        lastName = lastName,
        income = income,
        street = street,
        zipCode = zipCode
    )
}