package ru.alex3koval.docGenerator.configuration.di.domainModule

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    DomainRepositoryConfiguration::class,
    DomainServiceConfiguration::class,
    DomainCommandConfiguration::class
)
open class DomainModuleConfiguration
