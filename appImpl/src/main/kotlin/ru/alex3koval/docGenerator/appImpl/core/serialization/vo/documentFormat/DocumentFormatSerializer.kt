package ru.alex3koval.docGenerator.appImpl.core.serialization.vo.documentFormat

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.alex3koval.docGenerator.domain.vo.DocumentFormat

class DocumentFormatSerializer : JsonSerializer<DocumentFormat>() {
    override fun serialize(
        value: DocumentFormat?,
        gen: JsonGenerator?,
        serializers: SerializerProvider?
    ) {
        value?.value?.run { gen?.writeString(this) }
    }
}