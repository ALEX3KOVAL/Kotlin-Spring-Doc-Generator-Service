package ru.alex3koval.docGenerator.storage.converter.documentStatus

import org.springframework.core.convert.converter.Converter
import ru.alex3koval.docGenerator.domain.vo.DocumentStatus

class ReadingDocumentStatusConverter : Converter<UShort, DocumentStatus> {
    override fun convert(source: UShort): DocumentStatus? = DocumentStatus(source).getOrNull()
}
