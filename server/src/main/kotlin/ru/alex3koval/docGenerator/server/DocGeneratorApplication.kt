package ru.alex3koval.docGenerator.server

import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Import
import ru.alex3koval.docGenerator.configuration.AppEnvironment
import ru.alex3koval.docGenerator.server.configuration.MainConfiguration

@SpringBootApplication
@Import(MainConfiguration::class)
@EnableConfigurationProperties(AppEnvironment::class)
class DocGeneratorApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(DocGeneratorApplication::class.java)
        .web(WebApplicationType.REACTIVE)
        .run(*args)
}
