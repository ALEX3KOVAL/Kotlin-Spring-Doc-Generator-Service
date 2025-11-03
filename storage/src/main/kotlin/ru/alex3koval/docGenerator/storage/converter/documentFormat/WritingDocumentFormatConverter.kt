package ru.alex3koval.docGenerator.storage.converter.documentFormat

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter
import ru.alex3koval.docGenerator.domain.vo.DocumentFormat

@WritingConverter
class WritingDocumentFormatConverter : Converter<DocumentFormat, String> {
    override fun convert(source: DocumentFormat): String? = source.value
}
