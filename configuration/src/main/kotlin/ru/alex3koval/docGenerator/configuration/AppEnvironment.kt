package ru.alex3koval.docGenerator.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("app")
data class AppEnvironment(
    val retry: Map<String, RetryProps>,
    val webClient: Map<String, WebClientProps>
) {
    data class RetryProps(
        val maxAttempts: UShort,
        val minDelay: ULong,
        val jitter: Double
    )

    data class WebClientProps(
        val protocol: String,
        val host: String,
        val port: UInt
    )
}
