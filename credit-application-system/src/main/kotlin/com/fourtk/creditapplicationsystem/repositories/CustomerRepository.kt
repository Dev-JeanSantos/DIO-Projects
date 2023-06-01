package com.fourtk.creditapplicationsystem.repositories

import com.fourtk.creditapplicationsystem.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
}