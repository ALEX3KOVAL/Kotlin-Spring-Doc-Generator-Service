package ru.alex3koval.docGenerator.storage.converter.documentFormat

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import ru.alex3koval.docGenerator.domain.vo.DocumentFormat

@ReadingConverter
class ReadingDocumentFormatConverter : Converter<String, DocumentFormat> {
    override fun convert(source: String): DocumentFormat? = DocumentFormat(source).getOrNull()
}
