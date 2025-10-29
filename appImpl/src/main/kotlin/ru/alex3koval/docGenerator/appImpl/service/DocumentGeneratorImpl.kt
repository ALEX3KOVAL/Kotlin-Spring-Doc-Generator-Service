package ru.alex3koval.docGenerator.appImpl.service

import reactor.core.publisher.Mono
import ru.alex3koval.docGenerator.domain.contract.BaseGeneratedDocDTO
import ru.alex3koval.docGenerator.domain.contract.Document
import ru.alex3koval.docGenerator.domain.contract.DocumentGenerator

class DocumentGeneratorImpl<R, T : BaseGeneratedDocDTO<R>> : DocumentGenerator<R, T> {
    override fun generate(data: T): Mono<Document> {
        TODO("Not yet implemented")
    }
}
