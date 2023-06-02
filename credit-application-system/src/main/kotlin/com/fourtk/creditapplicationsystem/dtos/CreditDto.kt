package com.fourtk.creditapplicationsystem.dtos

import com.fourtk.creditapplicationsystem.entities.Credit
import com.fourtk.creditapplicationsystem.entities.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PastOrPresent
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Required field")
    val creditValue: BigDecimal,
    @field:Future(message = "Required field")
    val dayFirstOfInstallment: LocalDate,
    @field:NotNull(message = "Required field")
    val numberOfInstallments: Int,
    @field:NotNull(message = "Required field")
    val customId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customId)
    )

}
