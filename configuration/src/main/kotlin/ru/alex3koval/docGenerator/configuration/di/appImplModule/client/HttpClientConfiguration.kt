package ru.alex3koval.docGenerator.configuration.di.appImplModule.client

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import ru.alex3koval.docGenerator.configuration.AppEnvironment

@Configuration
class HttpClientConfiguration(
    private val appEnv: AppEnvironment
) {
    @Bean("fileServiceWebClientProps")
    fun fileServiceWebClientProps(): AppEnvironment.WebClientProps = appEnv
        .webClient["fileService"]
        ?: throw RuntimeException("Не найдена конфигурация для fileService WebClient")

    @Bean("unoconvWebClientProps")
    fun unoconvWebClientProps(): AppEnvironment.WebClientProps = appEnv
        .webClient["unoconv"]
        ?: throw RuntimeException("Не найдена конфигурация для unoconv WebClient")

    @Bean("fileServiceFacadeWebClient")
    fun fileServiceFacadeWebClient(
        @Qualifier("fileServiceWebClientProps") fileServiceWebClientProps: AppEnvironment.WebClientProps
    ): WebClient = WebClient
        .builder()
        .baseUrl(
            String.format(
                "%s://%s:%d/file",
                fileServiceWebClientProps.protocol,
                fileServiceWebClientProps.host,
                fileServiceWebClientProps.port
            )
        )
        .build()

    @Bean("unoconvWebClient")
    fun unoconvFacadeWebClient(
        @Qualifier("unoconvWebClientProps") unoconvWebClientProps: AppEnvironment.WebClientProps
    ): WebClient = WebClient
        .builder()
        .baseUrl(
            String.format(
                "%s://%s:%d/pdf",
                unoconvWebClientProps.protocol,
                unoconvWebClientProps.host,
                unoconvWebClientProps.port
            )
        )
        .build()
}
