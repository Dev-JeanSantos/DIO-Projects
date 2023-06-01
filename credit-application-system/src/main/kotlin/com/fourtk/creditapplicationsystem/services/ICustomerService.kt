package com.fourtk.creditapplicationsystem.services

import com.fourtk.creditapplicationsystem.entities.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}