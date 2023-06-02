package com.fourtk.creditapplicationsystem.controllers

import com.fourtk.creditapplicationsystem.dtos.*
import com.fourtk.creditapplicationsystem.entities.Credit
import com.fourtk.creditapplicationsystem.services.impl.CreditService
import org.springframework.web.bind.annotation.*
import java.util.*
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
    fun findById(@RequestParam(value = "customerId") customerId: Long): List<CreditViewList> {

       return creditService.findAllByCustomer(customerId).stream()
            .map { credit: Credit -> CreditViewList(credit) }.collect(Collectors.toList())
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long,
                         @PathVariable  creditCode: UUID): CreditView {
        val credit: Credit = creditService.findByCreditCode(customerId, creditCode)
        return  CreditView(credit)
    }
}
