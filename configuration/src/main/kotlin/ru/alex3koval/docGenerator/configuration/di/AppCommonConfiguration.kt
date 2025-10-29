package ru.alex3koval.docGenerator.configuration.di

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import ru.alex3koval.docGenerator.configuration.di.appImplModule.AppImplModuleConfiguration
import ru.alex3koval.docGenerator.configuration.di.domainModule.DomainModuleConfiguration
import ru.alex3koval.docGenerator.storage.StorageModuleConfiguration

@Configuration
@Import(
    DomainModuleConfiguration::class,
    TypeDependentConfiguration::class,
    AppImplModuleConfiguration::class,
    StorageModuleConfiguration::class
)
open class AppCommonConfiguration
