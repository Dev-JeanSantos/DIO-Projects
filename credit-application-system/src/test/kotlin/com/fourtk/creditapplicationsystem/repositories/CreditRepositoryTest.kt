package com.fourtk.creditapplicationsystem.repositories

import com.fourtk.creditapplicationsystem.entities.Credit
import com.fourtk.creditapplicationsystem.entities.Customer
import com.fourtk.creditapplicationsystem.mocks.BuildRepositoryCredit.buildRepositoryCredit
import com.fourtk.creditapplicationsystem.mocks.BuildRepositoryCustomer.buildRepositoryCustomer
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles
import java.util.*

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CreditRepositoryTest {

    @Autowired
    lateinit var repository: CreditRepository
    @Autowired
    lateinit var testEntityManager: TestEntityManager

    private lateinit var customer: Customer
    private lateinit var credit1: Credit
    private lateinit var credit2: Credit

    @BeforeEach
    fun setup () {
        //Salvando os dados no bd
        customer = testEntityManager.persist(buildRepositoryCustomer())
        credit1 = testEntityManager.persist(buildRepositoryCredit(customer = customer))!!
        credit2 = testEntityManager.persist(buildRepositoryCredit(customer = customer))!!
    }
    @Test
    fun `should find credit by credit code`() {
        val creditCode1 = UUID.fromString("baa0df4e-62b8-4dc9-ad8a-1f8236366a1b")
        val creditCode2 = UUID.fromString("337dd275-3064-4569-8b56-e3f41d705009")
        credit1.creditCode = creditCode1
        credit2.creditCode = creditCode2
        val fakeCredit1: Credit = repository.findByCreditCode(creditCode1)
        val fakeCredit2: Credit = repository.findByCreditCode(creditCode2)

        Assertions.assertThat(fakeCredit1).isNotNull
        Assertions.assertThat(fakeCredit2).isNotNull
        Assertions.assertThat(fakeCredit1).isSameAs(credit1)
        Assertions.assertThat(fakeCredit2).isSameAs(credit2)
    }

    @Test
    fun `should find all credits by customer id`() {
        val customerId: Long =  1L
        val creditList: List<Credit> = repository.findAllByCredits(customerId)

        Assertions.assertThat(creditList).isNotEmpty
        Assertions.assertThat(creditList.size).isEqualTo(2)
        Assertions.assertThat(creditList).contains(credit1, credit2)
    }
}