package ru.alex3koval.docGenerator.storage

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories("ru.alex3koval.docGenerator.storage.repository.orm")
@EntityScan("ru.alex3koval.docGenerator.storage.entity")
@EnableR2dbcAuditing
open class StorageModuleConfiguration
