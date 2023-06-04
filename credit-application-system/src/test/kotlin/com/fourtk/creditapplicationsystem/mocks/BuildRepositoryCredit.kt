package com.fourtk.creditapplicationsystem.mocks

import com.fourtk.creditapplicationsystem.entities.Credit
import com.fourtk.creditapplicationsystem.entities.Customer
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Month

object BuildRepositoryCredit {
    fun buildRepositoryCredit(
        creditValue: BigDecimal = BigDecimal.valueOf(900.0),
        dayFirstInstallment: LocalDate = LocalDate.of(2024, Month.AUGUST, 18),
        numberOfInstallments: Int = 12,
        customer: Customer
    ): Credit = Credit(
        creditValue = creditValue,
        dayFirstInstallment = dayFirstInstallment,
        numberOfInstallments = numberOfInstallments,
        customer = customer
    )
}