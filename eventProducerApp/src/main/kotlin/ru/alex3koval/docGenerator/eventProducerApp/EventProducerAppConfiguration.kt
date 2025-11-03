package ru.alex3koval.docGenerator.eventProducerApp

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.util.StdDateFormat
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import ru.alex3koval.eventingContract.dto.EventRDTO
import ru.alex3koval.transactionalOutBox.TransactionalOutBoxConfiguration
import ru.alex3koval.transactionalOutBox.serialization.EventRdtoDeserializer
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Configuration
@Import(TransactionalOutBoxConfiguration::class)
class EventProducerAppConfiguration {
    @Bean("cdcEventHandlerExecutorService")
    fun cdcEventHandlerExecutor(): ExecutorService = Executors.newFixedThreadPool(
        Runtime.getRuntime().availableProcessors() * 2
    )

    @Bean
    fun objectMapper(): ObjectMapper = ObjectMapper().apply {
        registerModule(JavaTimeModule())
        registerModule(
            SimpleModule().apply {
                addDeserializer(EventRDTO::class.java, EventRdtoDeserializer())
            }
        )

        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        setDateFormat(StdDateFormat().withColonInTimeZone(true))
    }
}
