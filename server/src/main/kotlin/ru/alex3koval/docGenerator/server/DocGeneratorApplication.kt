package ru.alex3koval.docGenerator.server

import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.EnableConfigurationProperties
import ru.alex3koval.docGenerator.configuration.AppEnvironment

@SpringBootApplication
@EnableConfigurationProperties(AppEnvironment::class)
class DocGeneratorApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(DocGeneratorApplication::class.java)
        .web(WebApplicationType.REACTIVE)
        .run(*args)
}
