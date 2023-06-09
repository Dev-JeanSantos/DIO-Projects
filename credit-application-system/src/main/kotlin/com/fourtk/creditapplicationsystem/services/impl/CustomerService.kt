package com.fourtk.creditapplicationsystem.services.impl

import com.fourtk.creditapplicationsystem.entities.Customer
import com.fourtk.creditapplicationsystem.exceptions.BussinesException
import com.fourtk.creditapplicationsystem.repositories.CustomerRepository
import com.fourtk.creditapplicationsystem.services.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(
    private val repository: CustomerRepository
): ICustomerService {

    override fun save(customer: Customer): Customer =  repository.save(customer)


    override fun findById(id: Long): Customer = repository.findById(id).orElseThrow{
    throw BussinesException("Id $id not found!")
    }

    override fun delete(id: Long){
        val customer: Customer = this.findById(id)
        repository.delete(customer)
    }
}