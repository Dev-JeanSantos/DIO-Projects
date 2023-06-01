package com.fourtk.creditapplicationsystem.repositories

import com.fourtk.creditapplicationsystem.entities.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository: JpaRepository<Credit, Long>{
}