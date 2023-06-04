package com.fourtk.creditapplicationsystem.services

import com.fourtk.creditapplicationsystem.entities.Customer
import com.fourtk.creditapplicationsystem.exceptions.BussinesException
import com.fourtk.creditapplicationsystem.mocks.BuildCustomer.buildCustomer
import com.fourtk.creditapplicationsystem.repositories.CustomerRepository
import com.fourtk.creditapplicationsystem.services.impl.CustomerService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.util.*

@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerServiceTest {

    @MockK
    lateinit var customerRepository: CustomerRepository
    @InjectMockKs
    lateinit var customerService: CustomerService



    @Test
    fun `should create customer`() {
        val customerMock: Customer = buildCustomer()
        every { customerRepository.save(any()) } returns customerMock
        val actual: Customer = customerService.save(customerMock)
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(customerMock)
        verify(exactly = 1) { customerRepository.save(customerMock) }
    }

    @Test
    fun `should find customer by id`() {

        val fakeId: Long = Random().nextLong()
        val fakeCustomer: Customer = buildCustomer(id = fakeId)
        every { customerRepository.findById(fakeId) } returns Optional.of(fakeCustomer)
        val actual: Customer = customerService.findById(fakeId)
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isExactlyInstanceOf(Customer::class.java)
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
        verify(exactly = 1) { customerRepository.findById(fakeId) }
    }

    @Test
    fun `should not find customer by invalid id and throw BusinessException`() {
        val fakeId: Long = Random().nextLong()
        every { customerRepository.findById(fakeId) } returns Optional.empty()
        Assertions.assertThatExceptionOfType(BussinesException::class.java)
            .isThrownBy { customerService.findById(fakeId) }
            .withMessage("Id $fakeId not found!")
        verify(exactly = 1) { customerRepository.findById(fakeId) }
    }

    @Test
    fun `should delete customer by id`() {
        val fakeId: Long = Random().nextLong()
        val fakeCustomer: Customer = buildCustomer(id = fakeId)
        every { customerRepository.findById(fakeId) } returns Optional.of(fakeCustomer)
        every { customerRepository.delete(fakeCustomer) } just runs
        customerService.delete(fakeId)
        verify(exactly = 1) { customerRepository.findById(fakeId) }
        verify(exactly = 1) { customerRepository.delete(fakeCustomer) }
    }

}

