package ru.alex3koval.docGenerator.server.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import ru.alex3koval.docGenerator.configuration.di.AppCommonConfiguration

@Configuration
@Import(AppCommonConfiguration::class)
@EnableWebFlux
@ComponentScan("ru.alex3koval.docGenerator.storage")
class MainConfiguration(
    private val objectMapper: ObjectMapper
) : WebFluxConfigurer {
    override fun configureHttpMessageCodecs(configurer: ServerCodecConfigurer) {
        configurer
            .defaultCodecs()
            .jackson2JsonEncoder(
                Jackson2JsonEncoder(objectMapper)
            )
    }
}
