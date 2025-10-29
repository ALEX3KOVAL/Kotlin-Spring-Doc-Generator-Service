package ru.alex3koval.docGenerator.domain.service

import reactor.core.publisher.Mono
import ru.alex3koval.docGenerator.domain.contract.BaseGeneratedDocDTO
import ru.alex3koval.docGenerator.domain.entity.DocumentEntity
import ru.alex3koval.docGenerator.domain.repository.document.dto.DocumentRDTO

interface DocumentService<T, R> {
    fun createDocument(
        fileId: R,
        domainDto: BaseGeneratedDocDTO<R>
    ): Mono<T>

    fun DocumentRDTO<T, R>.toEntity(): DocumentEntity<T, R> = DocumentEntity(
        id = id,
        model = model,
        format = format,
        fileId = fileId
    )
}
