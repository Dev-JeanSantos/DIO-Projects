package com.fourtk.creditapplicationsystem.mocks

import com.fourtk.creditapplicationsystem.entities.Credit
import com.fourtk.creditapplicationsystem.entities.Customer
import java.math.BigDecimal
import java.time.LocalDate

object BuildCredit {
    fun  buildCredit(
        creditValue: BigDecimal = BigDecimal.valueOf(100.0),
        dayFirstInstallment: LocalDate = LocalDate.now().plusMonths(2L),
        numberOfInstallments: Int = 15,
        customer: Customer = BuildCustomer.buildCustomer()
    )= Credit(
        creditValue = creditValue,
        dayFirstInstallment = dayFirstInstallment,
        numberOfInstallments = numberOfInstallments,
        customer = customer
    )
}