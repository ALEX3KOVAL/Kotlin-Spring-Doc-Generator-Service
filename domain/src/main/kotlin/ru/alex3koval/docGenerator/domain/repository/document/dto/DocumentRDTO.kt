package ru.alex3koval.docGenerator.domain.repository.document.dto

import ru.alex3koval.docGenerator.domain.vo.DocumentFormat
import java.time.LocalDateTime

data class DocumentRDTO<T, R>(
    val id: T,
    val model: Map<String, Any>,
    val format: DocumentFormat,
    val fileId: R,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
