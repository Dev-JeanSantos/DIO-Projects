package com.fourtk.creditapplicationsystem.controllers

import com.fourtk.creditapplicationsystem.dtos.CustomerDto
import com.fourtk.creditapplicationsystem.dtos.CustomerUpdateDto
import com.fourtk.creditapplicationsystem.dtos.CustomerView
import com.fourtk.creditapplicationsystem.entities.Customer
import com.fourtk.creditapplicationsystem.services.impl.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {
    @PostMapping
    fun saveCustomer(@Valid @RequestBody customerDto: CustomerDto): ResponseEntity<CustomerView> {
        val saveCustomer = customerService.save(customerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerView(saveCustomer))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView {
        val customer: Customer = customerService.findById(id)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Long) = customerService.delete(id)

    @PatchMapping
    fun updateCustomer(@Valid @RequestParam(value = "customerId") id: Long,
                       @RequestBody customerUpdateDto: CustomerUpdateDto): CustomerView{
        val customer: Customer = customerService.findById(id)
        val customerUpdate = customerUpdateDto.toEntity(customer)
        val customerSave: Customer = customerService.save(customerUpdate)
        return CustomerView(customerSave)
    }
}
