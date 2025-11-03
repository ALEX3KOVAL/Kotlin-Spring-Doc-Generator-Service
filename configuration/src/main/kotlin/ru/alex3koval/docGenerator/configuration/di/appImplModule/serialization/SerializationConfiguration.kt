package ru.alex3koval.docGenerator.configuration.di.appImplModule.serialization

import com.fasterxml.jackson.databind.module.SimpleModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.alex3koval.docGenerator.appImpl.core.serialization.vo.documentFormat.DocumentFormatDeserializer
import ru.alex3koval.docGenerator.appImpl.core.serialization.vo.documentFormat.DocumentFormatSerializer
import ru.alex3koval.docGenerator.appImpl.core.serialization.vo.documentStatus.DocumentStatusDeserializer
import ru.alex3koval.docGenerator.appImpl.core.serialization.vo.documentStatus.DocumentStatusSerializer
import ru.alex3koval.docGenerator.domain.vo.DocumentFormat
import ru.alex3koval.docGenerator.domain.vo.DocumentStatus

@Configuration
class SerializationConfiguration {
    @Bean("domainVoSerializationModule")
    fun domainVoSerializationModule(): SimpleModule {
        return SimpleModule().apply {
            addSerializer(DocumentFormat::class.java, DocumentFormatSerializer())
            addDeserializer(DocumentFormat::class.java, DocumentFormatDeserializer())

            addSerializer(DocumentStatus::class.java, DocumentStatusSerializer())
            addDeserializer(DocumentStatus::class.java, DocumentStatusDeserializer())
        }
    }
}
