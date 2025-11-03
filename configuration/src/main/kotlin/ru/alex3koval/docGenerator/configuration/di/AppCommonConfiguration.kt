package ru.alex3koval.docGenerator.configuration.di

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import ru.alex3koval.docGenerator.configuration.di.appImplModule.AppImplModuleConfiguration
import ru.alex3koval.docGenerator.configuration.di.domainModule.DomainModuleConfiguration
import ru.alex3koval.docGenerator.storage.StorageModuleConfiguration
import ru.alex3koval.eventingImpl.EventingConfiguration

@Configuration
@Import(
    DomainModuleConfiguration::class,
    AppImplModuleConfiguration::class,
    StorageModuleConfiguration::class,
    EventingConfiguration::class,
    TypeDependentConfiguration::class
)
class AppCommonConfiguration
