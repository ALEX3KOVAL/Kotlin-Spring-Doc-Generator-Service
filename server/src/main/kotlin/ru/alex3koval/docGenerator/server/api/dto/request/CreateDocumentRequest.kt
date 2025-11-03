package ru.alex3koval.docGenerator.server.api.dto.request

import ru.alex3koval.docGenerator.domain.vo.DocumentFormat

data class CreateDocumentRequest<TEMPLATE_ID: Any>(
    val filename: String,
    val templateId: TEMPLATE_ID,
    val format: DocumentFormat,
    val model: Map<String, Any>
)
