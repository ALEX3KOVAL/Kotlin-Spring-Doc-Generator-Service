package ru.alex3koval.docGenerator.domain.entity

import ru.alex3koval.docGenerator.domain.vo.DocumentFormat

class DocumentEntity<T, R> internal constructor(
    val id: T,
    val fileId: R,
    val model: Map<String, Any>,
    val format: DocumentFormat
)
