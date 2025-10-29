package ru.alex3koval.docGenerator.configuration.di.appImplModule

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import ru.alex3koval.docGenerator.configuration.di.appImplModule.client.HttpClientConfiguration

@Configuration
@Import(HttpClientConfiguration::class)
class AppImplModuleConfiguration {
}
