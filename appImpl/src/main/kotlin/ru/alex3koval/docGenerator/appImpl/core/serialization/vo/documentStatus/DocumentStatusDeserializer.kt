package ru.alex3koval.docGenerator.appImpl.core.serialization.vo.documentStatus

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import ru.alex3koval.docGenerator.domain.vo.DocumentStatus

class DocumentStatusDeserializer : JsonDeserializer<DocumentStatus>() {
    override fun deserialize(
        p: JsonParser?,
        ctxt: DeserializationContext?
    ): DocumentStatus? {
        if (p!!.currentToken != JsonToken.VALUE_NUMBER_INT) {
            p.nextToken()
        }

        return DocumentStatus(p.text).getOrNull()
    }
}
