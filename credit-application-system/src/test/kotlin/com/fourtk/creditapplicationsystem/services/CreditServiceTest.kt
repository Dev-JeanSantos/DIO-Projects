package com.fourtk.creditapplicationsystem.services

import com.fourtk.creditapplicationsystem.entities.Credit
import com.fourtk.creditapplicationsystem.entities.Customer
import com.fourtk.creditapplicationsystem.exceptions.BussinesException
import com.fourtk.creditapplicationsystem.mocks.BuildCredit.buildCredit
import com.fourtk.creditapplicationsystem.mocks.BuildCustomer.buildCustomer
import com.fourtk.creditapplicationsystem.repositories.CreditRepository
import com.fourtk.creditapplicationsystem.repositories.CustomerRepository
import com.fourtk.creditapplicationsystem.services.impl.CreditService
import com.fourtk.creditapplicationsystem.services.impl.CustomerService
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDate
import java.util.*

@ExtendWith(MockKExtension::class)
class CreditServiceTest {

    @MockK
    lateinit var creditRepository: CreditRepository
    @MockK
    lateinit var customerService: CustomerService
    @InjectMockKs
    lateinit var creditService: CreditService

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @AfterEach
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `should create credit `() {

        val credit: Credit = buildCredit()
        val customerId: Long = 1L
        every { customerService.findById(customerId) } returns credit.customer!!
        every { creditRepository.save(credit) } returns credit
        val actual: Credit = this.creditService.save(credit)
        verify(exactly = 1) { customerService.findById(customerId) }
        verify(exactly = 1) { creditRepository.save(credit) }

        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(credit)
    }

//    @Test
//    fun `should not create credit when invalid day first installment`() {
//
//        val invalidDayFirstInstallment: LocalDate = LocalDate.now().plusMonths(1)
//        val credit: Credit = buildCredit(dayFirstInstallment = invalidDayFirstInstallment)
//        every { creditRepository.save(credit) } answers { credit }
//        Assertions.assertThatThrownBy { creditService.save(credit) }
//            .isInstanceOf(BussinesException::class.java)
//            .hasMessage("Invalid Date")
//        verify(exactly = 0) { creditRepository.save(any()) }
//    }

    @Test
    fun `should return list of credits for a customer`() {

        val customerId: Long = 1L
        val expectedCredits: List<Credit> = listOf(buildCredit(), buildCredit(), buildCredit())
        every { creditRepository.findAllByCredits(customerId) } returns expectedCredits
        val actual: List<Credit> = creditService.findAllByCustomer(customerId)
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isNotEmpty
        Assertions.assertThat(actual).isSameAs(expectedCredits)

        verify(exactly = 1) { creditRepository.findAllByCredits(customerId) }
    }

    @Test
    fun `should return credit for a valid customer and credit code`() {

        val customerId: Long = 1L
        val creditCode: UUID = UUID.randomUUID()
        val credit: Credit = buildCredit(customer = Customer(id = customerId))

        every { creditRepository.findByCreditCode(creditCode) } returns credit
        val actual: Credit = creditService.findByCreditCode(customerId, creditCode)
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(credit)

        verify(exactly = 1) { creditRepository.findByCreditCode(creditCode) }
    }

//    @Test
//    fun `should throw BusinessException for invalid credit code`() {
//        val customerId: Long = 1L
//        val invalidCreditCode: UUID = UUID.randomUUID()
//
//        every { creditRepository.findByCreditCode(invalidCreditCode) } returns null
//        Assertions.assertThatThrownBy { creditService.findByCreditCode(customerId, invalidCreditCode) }
//            .isInstanceOf(BussinesException::class.java)
//            .hasMessage("Creditcode $invalidCreditCode not found")
//        verify(exactly = 1) { creditRepository.findByCreditCode(invalidCreditCode) }
//    }

    @Test
    fun `should throw IllegalArgumentException for different customer ID`() {
        val customerId: Long = 1L
        val creditCode: UUID = UUID.randomUUID()
        val credit: Credit = buildCredit(customer = Customer(id = 2L))

        every { creditRepository.findByCreditCode(creditCode) } returns credit
        Assertions.assertThatThrownBy { creditService.findByCreditCode(customerId, creditCode) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Contact admin")

        verify { creditRepository.findByCreditCode(creditCode) }
    }

}

