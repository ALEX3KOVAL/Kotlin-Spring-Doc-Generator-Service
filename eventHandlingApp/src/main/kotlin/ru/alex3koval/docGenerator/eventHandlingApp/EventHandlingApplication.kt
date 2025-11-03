package ru.alex3koval.docGenerator.eventHandlingApp

import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.EnableConfigurationProperties
import ru.alex3koval.docGenerator.configuration.AppEnvironment
import ru.alex3koval.kafkaEventer.EventerProperties

@SpringBootApplication
@EnableConfigurationProperties(
    EventerProperties::class,
    AppEnvironment::class
)
class EventHandlingApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(EventHandlingApplication::class.java)
        .web(WebApplicationType.REACTIVE)
        .run(*args)
}
