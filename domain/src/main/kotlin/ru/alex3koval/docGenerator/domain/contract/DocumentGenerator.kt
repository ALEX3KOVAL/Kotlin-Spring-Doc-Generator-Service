package ru.alex3koval.docGenerator.domain.contract

import reactor.core.publisher.Mono

interface DocumentGenerator {
    fun <DTO : BaseGeneratedDocDTO> generate(data: DTO): Mono<Document>
}
