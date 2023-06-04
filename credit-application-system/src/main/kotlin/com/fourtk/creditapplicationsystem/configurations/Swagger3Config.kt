package com.fourtk.creditapplicationsystem.configurations

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(info = Info(title = "Credit Application System",
    description = "Financial loan management application", version = "v1"))
class Swagger3Config {

    @Bean
    fun publicApi(): GroupedOpenApi?{
        return GroupedOpenApi.builder()
            .group("springcreditapplicationsystems.public")
            .pathsToMatch("/api/customers/**", "/api/credits/**")
            .build()
    }
}