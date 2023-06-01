package com.fourtk.creditapplicationsystem.services.impl

import com.fourtk.creditapplicationsystem.entities.Credit
import com.fourtk.creditapplicationsystem.repositories.CreditRepository
import com.fourtk.creditapplicationsystem.services.ICreditService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class CreditService(
    private val repository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return  repository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {

        TODO("Not yet implemented")
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = repository.findByCreditCode(creditCode) ?: throw RuntimeException("Credit $creditCode not found")
        return if(credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }
}