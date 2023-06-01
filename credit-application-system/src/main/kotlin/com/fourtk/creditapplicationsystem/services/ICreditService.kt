package com.fourtk.creditapplicationsystem.services

import com.fourtk.creditapplicationsystem.entities.Credit
import java.util.UUID

interface ICreditService {

    fun save(credit:Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(creditCode: UUID): Credit
}