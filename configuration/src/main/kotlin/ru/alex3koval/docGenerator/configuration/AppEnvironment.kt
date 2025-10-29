package ru.alex3koval.docGenerator.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("app")
data class AppEnvironment(
    val webClient: Map<String, WebClientProps>
) {
    data class WebClientProps(
        val protocol: String,
        val host: String,
        val port: UInt
    )
}
