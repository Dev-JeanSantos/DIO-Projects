package com.fourtk.creditapplicationsystem.services

import com.fourtk.creditapplicationsystem.entities.Customer
import com.fourtk.creditapplicationsystem.mocks.BuildCustomer
import com.fourtk.creditapplicationsystem.repositories.CustomerRepository
import com.fourtk.creditapplicationsystem.services.impl.CustomerService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerServiceTest {

    @MockK
    lateinit var customerRepository: CustomerRepository
    @InjectMockKs
    lateinit var customerService: CustomerService

    @Test
    fun `should create customer`() {
        val customerMock: Customer = BuildCustomer.buildCustomer()
        every { customerRepository.save(any()) } returns customerMock
        val actual: Customer = customerService.save(customerMock)
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(customerMock)
        verify(exactly = 1) { customerRepository.save(customerMock) }
    }

}

