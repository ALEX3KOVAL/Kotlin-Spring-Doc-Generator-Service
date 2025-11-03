package ru.alex3koval.docGenerator.storage

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions
import org.springframework.data.r2dbc.dialect.PostgresDialect
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import ru.alex3koval.docGenerator.storage.converter.documentFormat.ReadingDocumentFormatConverter
import ru.alex3koval.docGenerator.storage.converter.documentFormat.WritingDocumentFormatConverter
import ru.alex3koval.docGenerator.storage.converter.documentStatus.ReadingDocumentStatusConverter
import ru.alex3koval.docGenerator.storage.converter.documentStatus.WritingDocumentStatusConverter
import ru.alex3koval.docGenerator.storage.converter.eventStatus.ReadingEventStatusConverter
import ru.alex3koval.docGenerator.storage.converter.eventStatus.WritingEventStatusConverter

@Configuration
@EnableR2dbcRepositories("ru.alex3koval.docGenerator.storage.repository.orm")
@EntityScan("ru.alex3koval.docGenerator.storage.entity")
@EnableR2dbcAuditing
class StorageModuleConfiguration {
    @Bean
    fun r2dbcCustomConversions(): R2dbcCustomConversions {
        val converters = listOf<Converter<*, *>>(
            WritingDocumentFormatConverter(),
            ReadingDocumentFormatConverter(),

            WritingDocumentStatusConverter(),
            ReadingDocumentStatusConverter(),

            WritingEventStatusConverter(),
            ReadingEventStatusConverter()
        )

        return R2dbcCustomConversions.of(PostgresDialect.INSTANCE, converters)
    }
}
