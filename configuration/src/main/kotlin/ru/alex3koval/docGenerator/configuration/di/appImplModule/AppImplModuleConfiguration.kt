package ru.alex3koval.docGenerator.configuration.di.appImplModule

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Scope
import ru.alex3koval.docGenerator.appImpl.model.RetryConfigurations
import ru.alex3koval.docGenerator.appImpl.service.RetryService
import ru.alex3koval.docGenerator.appImpl.service.factory.DocxGeneratorFactory
import ru.alex3koval.docGenerator.appImpl.service.factory.RetryServiceFactory
import ru.alex3koval.docGenerator.configuration.AppEnvironment
import ru.alex3koval.docGenerator.configuration.di.appImplModule.client.HttpClientConfiguration
import ru.alex3koval.docGenerator.configuration.di.appImplModule.serialization.JacksonConfiguration
import ru.alex3koval.docGenerator.configuration.di.appImplModule.serialization.SerializationConfiguration

@Configuration
@Import(
    HttpClientConfiguration::class,
    JacksonConfiguration::class,
    SerializationConfiguration::class
)
class AppImplModuleConfiguration(
    private val appEnv: AppEnvironment
) {
    @Bean
    fun retryConfigs(): RetryConfigurations = RetryConfigurations(
        configs = appEnv
            .retry
            .mapValues { (_, props) ->
                RetryConfigurations.Props(
                    maxAttempts = props.maxAttempts,
                    minDelay = props.minDelay,
                    jitter = props.jitter
                )
            }
    )

    @Bean
    fun retryServiceFactory(retryConfigs: RetryConfigurations) = RetryServiceFactory(
        retryConfigs = retryConfigs
    )

    @Bean
    fun docxGeneratorFactory(): DocxGeneratorFactory = DocxGeneratorFactory()

    @Bean("fileServiceRetry")
    @Scope("prototype")
    fun fileServiceRetryService(
        retryServiceFactory: RetryServiceFactory
    ): RetryService = retryServiceFactory.create(retryName = "file-service")
}
