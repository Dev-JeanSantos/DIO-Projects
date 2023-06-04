package com.fourtk.creditapplicationsystem.mocks

import com.fourtk.creditapplicationsystem.entities.Address
import com.fourtk.creditapplicationsystem.entities.Customer
import java.math.BigDecimal

object BuildRepositoryCustomer {
  fun buildRepositoryCustomer(
        firstName: String = "Marcos",
        lastName: String = "Silva",
        cpf: String = "96637453048",
        email: String = "marcos@email.com",
        password: String = "654321",
        zipCode: String = "654321",
        street: String = "Avenida Brasil",
        income: BigDecimal = BigDecimal.valueOf(25000.0),
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
    )
}

