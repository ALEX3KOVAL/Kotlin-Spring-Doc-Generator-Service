package ru.alex3koval.docGenerator.common.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import ru.alex3koval.docGenerator.common.checker.TopicsCheckerAppRunner
import ru.alex3koval.eventingImpl.factory.KafkaTopicsFetcherFactory

@Configuration
class CheckerConfiguration {
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    fun topicsCheckerAppRunner(
        kafkaTopicsFetcherFactory: KafkaTopicsFetcherFactory
    ): TopicsCheckerAppRunner = TopicsCheckerAppRunner(
        factory = kafkaTopicsFetcherFactory
    )
}
