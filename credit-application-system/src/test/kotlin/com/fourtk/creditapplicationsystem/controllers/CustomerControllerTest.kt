package com.fourtk.creditapplicationsystem.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fourtk.creditapplicationsystem.dtos.CustomerDto
import com.fourtk.creditapplicationsystem.dtos.CustomerUpdateDto
import com.fourtk.creditapplicationsystem.entities.Customer
import com.fourtk.creditapplicationsystem.mocks.BuildCustomerDto.buildCustomerDto
import com.fourtk.creditapplicationsystem.mocks.BuildCustomerUpdateDto
import com.fourtk.creditapplicationsystem.repositories.CustomerRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*
import com.fourtk.creditapplicationsystem.mocks.BuildCustomerUpdateDto.buildCustomerUpdateDto as buildCustomerUpdateDto

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@ContextConfiguration
class CustomerControllerTest {

    @Autowired
    private lateinit var repository: CustomerRepository

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    companion object {
        const val URL: String = "/api/customers"
    }

    @BeforeEach
    fun setup() = repository.deleteAll()

    @AfterEach
    fun tearDown() = repository.deleteAll()


    @Test
    fun `should create a customer and return 201 status`() {
        val dto: CustomerDto = buildCustomerDto()
        //converter em String
        val dtoConverterString: String = objectMapper.writeValueAsString(dto)

        mockMvc.perform(
            MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(dtoConverterString)
        )
            .andExpect(MockMvcResultMatchers.status().isCreated)
            .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Fulano"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Silva"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value("96637453048"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("joao@email.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.income").value("500.0"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.zipCode").value("654321"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.street").value("Rua A"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
            .andDo(MockMvcResultHandlers.print())
    }


    @Test
    fun `should not save a customer with same CPF and return 409 status`() {
        repository.save(buildCustomerDto().toEntity())
        val customerDto: CustomerDto = buildCustomerDto()
        val valueAsString: String = objectMapper.writeValueAsString(customerDto)
        mockMvc.perform(
            MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(valueAsString)
        )
            .andExpect(MockMvcResultMatchers.status().isConflict)
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Conflit, CPF duplicate!"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(409))
            .andExpect(
                MockMvcResultMatchers.jsonPath("$.exception")
                    .value("class org.springframework.dao.DataIntegrityViolationException")
            )
            .andExpect(MockMvcResultMatchers.jsonPath("$.details[*]").isNotEmpty)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `should not save a customer with empty firstName and return 400 status`() {
        val customerDto: CustomerDto = buildCustomerDto(firstName = "")
        val valueAsString: String = objectMapper.writeValueAsString(customerDto)
        mockMvc.perform(
            MockMvcRequestBuilders.post(URL)
                .content(valueAsString)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Bad Request! Consult the documentation"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
            .andExpect(
                MockMvcResultMatchers.jsonPath("$.exception")
                    .value("class org.springframework.web.bind.MethodArgumentNotValidException")
            )
            .andExpect(MockMvcResultMatchers.jsonPath("$.details[*]").isNotEmpty)
            .andDo(MockMvcResultHandlers.print())
    }
    @Test
    fun `should find customer by id and return 200 status`() {
        val customer: Customer = repository.save(buildCustomerDto().toEntity())
        mockMvc.perform(
            MockMvcRequestBuilders.get("$URL/${customer.id}")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Fulano"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Silva"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value("96637453048"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("joao@email.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.income").value("500.0"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.zipCode").value("654321"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.street").value("Rua A"))
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `should not find customer with invalid id and return 400 status`() {
        val invalidId: Long = 2L
        mockMvc.perform(
            MockMvcRequestBuilders.get("$URL/$invalidId")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Bad Request! Consult the documentation"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
            .andExpect(
                MockMvcResultMatchers.jsonPath("$.exception")
                    .value("class com.fourtk.creditapplicationsystem.exceptions.BussinesException")
            )
            .andExpect(MockMvcResultMatchers.jsonPath("$.details[*]").isNotEmpty)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `should delete customer by id and return 204 status`() {
        val customer: Customer = repository.save(buildCustomerDto().toEntity())
        mockMvc.perform(
            MockMvcRequestBuilders.delete("$URL/${customer.id}")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isNoContent)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `should not delete customer by id and return 400 status`() {
        val invalidId: Long = Random().nextLong()
        mockMvc.perform(
            MockMvcRequestBuilders.delete("$URL/${invalidId}")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Bad Request! Consult the documentation"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
            .andExpect(
                MockMvcResultMatchers.jsonPath("$.exception")
                    .value("class com.fourtk.creditapplicationsystem.exceptions.BussinesException")
            )
            .andExpect(MockMvcResultMatchers.jsonPath("$.details[*]").isNotEmpty)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `should update a customer and return 200 status`() {
        val customer: Customer = repository.save(buildCustomerDto().toEntity())
        val customerUpdateDto: CustomerUpdateDto = buildCustomerUpdateDto()
        val valueAsString: String = objectMapper.writeValueAsString(customerUpdateDto)

        mockMvc.perform(
            MockMvcRequestBuilders.patch("$URL?customerId=${customer.id}")
                .contentType(MediaType.APPLICATION_JSON)
                .content(valueAsString)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Fulano-Update"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Silva-Update"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value("96637453048"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("joao@email.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.income").value("1000.0"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.zipCode").value("654321-Update"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.street").value("Rua A-Update"))
            .andDo(MockMvcResultHandlers.print())
    }


}
