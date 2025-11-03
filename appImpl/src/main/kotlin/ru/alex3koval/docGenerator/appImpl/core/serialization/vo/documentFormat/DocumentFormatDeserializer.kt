package ru.alex3koval.docGenerator.appImpl.core.serialization.vo.documentFormat

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.alex3koval.docGenerator.domain.vo.DocumentFormat

class DocumentFormatDeserializer : JsonDeserializer<DocumentFormat>() {
    override fun deserialize(
        p: JsonParser?,
        ctxt: DeserializationContext?
    ): DocumentFormat? {
        if (p!!.currentToken != JsonToken.VALUE_NUMBER_INT) {
            p.nextToken()
        }

        return DocumentFormat(p.text).getOrNull()
    }
}