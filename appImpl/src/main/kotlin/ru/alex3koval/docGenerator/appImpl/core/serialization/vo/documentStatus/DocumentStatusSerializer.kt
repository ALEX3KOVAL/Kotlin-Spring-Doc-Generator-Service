package ru.alex3koval.docGenerator.appImpl.core.serialization.vo.documentStatus

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.alex3koval.docGenerator.domain.vo.DocumentStatus

class DocumentStatusSerializer : JsonSerializer<DocumentStatus>() {
    override fun serialize(
        value: DocumentStatus?,
        gen: JsonGenerator?,
        serializers: SerializerProvider?
    ) {
        value?.value?.run {
            gen?.writeNumber(toLong())
        }
    }
}
