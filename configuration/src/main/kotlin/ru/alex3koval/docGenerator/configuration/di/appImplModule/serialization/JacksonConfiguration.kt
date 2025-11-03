package ru.alex3koval.docGenerator.configuration.di.appImplModule.serialization

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class JacksonConfiguration {
    @Primary
    @Bean
    fun objectMapper(
        @Qualifier("domainVoSerializationModule") domainVoSerializationModule: SimpleModule
    ): ObjectMapper = ObjectMapper().apply {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        registerModule(domainVoSerializationModule)
    }
}
