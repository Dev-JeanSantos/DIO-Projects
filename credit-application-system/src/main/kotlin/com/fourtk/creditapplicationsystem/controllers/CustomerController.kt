package com.fourtk.creditapplicationsystem.controllers

import com.fourtk.creditapplicationsystem.dtos.CustomerDto
import com.fourtk.creditapplicationsystem.dtos.CustomerView
import com.fourtk.creditapplicationsystem.entities.Customer
import com.fourtk.creditapplicationsystem.services.impl.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {
    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val saveCustomer = customerService.save(customerDto.toEntity())
        return "Customer ${saveCustomer.email} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView {
        val customer: Customer = customerService.findById(id)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = customerService.delete(id)

}