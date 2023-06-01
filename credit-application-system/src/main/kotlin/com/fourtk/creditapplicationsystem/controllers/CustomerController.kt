package com.fourtk.creditapplicationsystem.controllers

import com.fourtk.creditapplicationsystem.dtos.CustomerDto
import com.fourtk.creditapplicationsystem.services.impl.CustomerService
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
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String{
        val saveCustomer = customerService.save(customerDto.toEntity())
        return "Customer ${saveCustomer.email} saved!"
    }

}