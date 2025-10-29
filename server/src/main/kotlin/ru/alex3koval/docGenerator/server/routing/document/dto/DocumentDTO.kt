package ru.alex3koval.docGenerator.server.routing.document.dto

import ru.alex3koval.docGenerator.domain.entity.DocumentEntity
import ru.alex3koval.docGenerator.domain.vo.DocumentFormat

class DocumentDTO <T, R> private constructor(
    val id: T,
    val model: Map<String, Any>,
    val format: DocumentFormat,
    val fileId: R,
) {
    companion object {
        fun <T, R> fromDomainEntity(entity: DocumentEntity<T, R>): DocumentDTO<T, R> = with(entity) {
            DocumentDTO(
                id = id,
                model = model,
                format = format,
                fileId = fileId
            )
        }
    }
}
