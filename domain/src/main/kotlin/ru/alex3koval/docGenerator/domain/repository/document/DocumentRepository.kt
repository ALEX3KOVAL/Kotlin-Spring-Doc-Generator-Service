package ru.alex3koval.docGenerator.domain.repository.document

import reactor.core.publisher.Mono
import ru.alex3koval.docGenerator.domain.repository.document.dto.CreateDocumentWDTO

interface DocumentRepository<T : Any, R> {
    fun create(dto: CreateDocumentWDTO<R>): Mono<T>
}
