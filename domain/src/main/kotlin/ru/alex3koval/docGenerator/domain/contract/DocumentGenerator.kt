package ru.alex3koval.docGenerator.domain.contract

import reactor.core.publisher.Mono

interface DocumentGenerator<R, T: BaseGeneratedDocDTO<R>> {
    fun generate(data: T): Mono<Document>
}
