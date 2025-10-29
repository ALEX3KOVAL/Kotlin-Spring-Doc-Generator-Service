package ru.alex3koval.docGenerator.domain.repository.document.dto

import ru.alex3koval.docGenerator.domain.vo.DocumentFormat
import java.time.LocalDateTime

data class CreateDocumentWDTO<T>(
    val jsonModel: String,
    val fileId: T,
    val format: DocumentFormat,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
