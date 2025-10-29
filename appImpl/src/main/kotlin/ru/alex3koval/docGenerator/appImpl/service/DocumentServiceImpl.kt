package ru.alex3koval.docGenerator.appImpl.service

import com.fasterxml.jackson.databind.ObjectMapper
import reactor.core.publisher.Mono
import ru.alex3koval.docGenerator.domain.contract.BaseGeneratedDocDTO
import ru.alex3koval.docGenerator.domain.repository.document.DocumentRepository
import ru.alex3koval.docGenerator.domain.repository.document.dto.CreateDocumentWDTO
import ru.alex3koval.docGenerator.domain.service.DocumentService
import java.time.LocalDateTime
import java.time.ZoneOffset

class DocumentServiceImpl<T : Any, R>(
    private val repository: DocumentRepository<T, R>,
    private val objectMapper: ObjectMapper
) : DocumentService<T, R> {
    override fun createDocument(
        fileId: R,
        domainDto: BaseGeneratedDocDTO<R>
    ): Mono<T> = repository.create(
        toCreationWdto(
            fileId = fileId,
            domainDto = domainDto
        )
    )

    private fun toCreationWdto(
        fileId: R,
        domainDto: BaseGeneratedDocDTO<R>
    ): CreateDocumentWDTO<R> = run {
        val now = LocalDateTime.now(ZoneOffset.UTC)

        CreateDocumentWDTO(
            jsonModel = objectMapper.writeValueAsString(domainDto),
            format = domainDto.format,
            fileId = fileId,
            createdAt = now,
            updatedAt = now
        )
    }
}
