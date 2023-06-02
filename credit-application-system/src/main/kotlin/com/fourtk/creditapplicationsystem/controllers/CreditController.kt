package com.fourtk.creditapplicationsystem.controllers

import com.fourtk.creditapplicationsystem.dtos.*
import com.fourtk.creditapplicationsystem.entities.Credit
import com.fourtk.creditapplicationsystem.entities.Customer
import com.fourtk.creditapplicationsystem.services.impl.CreditService
import org.springframework.web.bind.annotation.*
import java.util.Collections
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {
    @PostMapping
    fun saveCustomer(@RequestBody creditDto: CreditDto): String {
        val saveCredit: Credit = creditService.save(creditDto.toEntity())
        return "Credit ${saveCredit.creditCode} - Customer ${saveCredit.customer?.firstName} saved!"
    }

    @GetMapping
    fun findById(@RequestParam(value = "customerId") id: Long): CreditViewList {

       return creditService.findAllByCustomer(id).stream()
            .map { credit: Credit -> CreditViewList(credit) }.collect(Collectors.toList())
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = customerService.delete(id)

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody customerUpdateDto: CustomerUpdateDto): CustomerView{
        val customer: Customer = customerService.findById(id)
        val customerUpdate = customerUpdateDto.toEntity(customer)
        val customerSave: Customer = customerService.save(customerUpdate)
        return CustomerView(customerSave)
    }
}
