package com.fourtk.creditapplicationsystem.mocks

import com.fourtk.creditapplicationsystem.entities.Address
import com.fourtk.creditapplicationsystem.entities.Customer
import java.math.BigDecimal

object BuildCustomer {
    fun buildCustomer(
        firstName: String = "Fulano",
        lastName: String = "Silva",
        cpf: String = "96637453048",
        email: String = "joao@email.com",
        password: String = "654321",
        zipCode: String = "654321",
        street: String = "Rua A",
        income: BigDecimal = BigDecimal.valueOf(500.0),
        id: Long = 1L
    ) = Customer(
        firstName = firstName,
        lastName = lastName,
        cpf = cpf,
        email = email,
        password = password,
        address = Address(
            zipCode = zipCode,
            street = street,
        ),
        income = income,
        id = id
    )
}