package ru.alex3koval.docGenerator.appImpl.service

import reactor.core.publisher.Mono
import ru.alex3koval.docGenerator.domain.contract.BaseGeneratedDocDTO
import ru.alex3koval.docGenerator.domain.contract.Document
import ru.alex3koval.docGenerator.domain.contract.DocumentGenerator

class DocumentGeneratorImpl : DocumentGenerator {
    override fun <DTO : BaseGeneratedDocDTO> generate(data: DTO): Mono<Document> {
        TODO("Not yet implemented")
    }
}
