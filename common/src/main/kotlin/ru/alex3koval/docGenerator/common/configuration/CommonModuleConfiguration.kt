package ru.alex3koval.docGenerator.common.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(CheckerConfiguration::class)
class CommonModuleConfiguration
