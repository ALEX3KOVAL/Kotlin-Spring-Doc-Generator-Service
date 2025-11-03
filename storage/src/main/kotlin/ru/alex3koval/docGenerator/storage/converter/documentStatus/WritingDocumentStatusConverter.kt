package ru.alex3koval.docGenerator.storage.converter.documentStatus

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter
import ru.alex3koval.docGenerator.domain.vo.DocumentStatus

@WritingConverter
class WritingDocumentStatusConverter : Converter<DocumentStatus, UShort> {
    override fun convert(source: DocumentStatus): UShort? = source.value
}
