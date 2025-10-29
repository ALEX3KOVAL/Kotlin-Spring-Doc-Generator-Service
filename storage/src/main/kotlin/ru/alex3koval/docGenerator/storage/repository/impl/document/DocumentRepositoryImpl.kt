package ru.alex3koval.docGenerator.storage.repository.impl.document

import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono
import ru.alex3koval.docGenerator.domain.repository.document.DocumentRepository
import ru.alex3koval.docGenerator.domain.repository.document.dto.CreateDocumentWDTO
import ru.alex3koval.docGenerator.storage.entity.Document
import ru.alex3koval.docGenerator.storage.repository.orm.OrmDocumentRepository

@Transactional
open class DocumentRepositoryImpl<T : Any, R>(
    private val ormRepository: OrmDocumentRepository<T, R>
) : DocumentRepository<T, R> {
    override fun create(dto: CreateDocumentWDTO<R>): Mono<T> = ormRepository
        .saveWithReturning(dto.toEntity())
        .mapNotNull<T> { document -> document.id }

    private fun CreateDocumentWDTO<R>.toEntity(): Document<T, R> = Document(
        fileId = fileId,
        jsonModel = jsonModel,
        format = format,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
