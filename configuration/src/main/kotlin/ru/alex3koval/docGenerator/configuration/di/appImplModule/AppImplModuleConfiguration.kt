package ru.alex3koval.docGenerator.configuration.di.appImplModule

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import ru.alex3koval.docGenerator.configuration.di.appImplModule.client.HttpClientConfiguration
import ru.alex3koval.docGenerator.configuration.di.appImplModule.serialization.JacksonConfiguration

@Configuration
@Import(
    HttpClientConfiguration::class,
    JacksonConfiguration::class
)
class AppImplModuleConfiguration
